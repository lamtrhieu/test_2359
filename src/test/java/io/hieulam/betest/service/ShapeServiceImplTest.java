package io.hieulam.betest.service;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.repository.ShapeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ShapeServiceImplTest {

    @Mock
    private ShapeRepository shapeRepository;

    private ShapeService shapeService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        shapeService = new ShapeServiceImpl(shapeRepository);
    }

    @Test
    void shouldThrowExceptionWhenGivenInvalidCategory() {
        given(shapeRepository.isShapeCategoryExist("test")).willReturn(false);

        //when
        Throwable thrown = catchThrowable(() -> {
            shapeService.submitShape(new ShapeCategory("test", null));
        });

        assertThat(thrown)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid Shape Category");

    }

    @Test
    void shouldSubmitSquareShape() {
        given(shapeRepository.isShapeCategoryExist("SQUARE")).willReturn(true);

        Attribute attribute = new Attribute("size", "cm");
        attribute.setValue("10");
        List<Attribute> attributes = Arrays.asList(attribute);

        Shape result = shapeService.submitShape(new ShapeCategory("SQUARE", attributes));
        assertThat(result.getShapeURL()).startsWith("http://service.com/SQUARE/");
        assertThat(result.getArea()).isEqualTo(100);
    }

    @Test
    void shouldSubmitTriangleShape() {
        given(shapeRepository.isShapeCategoryExist("TRIANGLE")).willReturn(true);

        Attribute base = new Attribute("base", "cm");
        base.setValue("10");
        Attribute height = new Attribute("height", "cm");
        height.setValue("10");
        List<Attribute> attributes = Arrays.asList(base, height);

        Shape result = shapeService.submitShape(new ShapeCategory("TRIANGLE", attributes));
        assertThat(result.getShapeURL()).startsWith("http://service.com/TRIANGLE/");
        assertThat(result.getArea()).isEqualTo(50);
    }

    @Test
    void shouldSubmitRectangleShape() {
        given(shapeRepository.isShapeCategoryExist("RECTANGLE")).willReturn(true);

        Attribute width = new Attribute("width", "cm");
        width.setValue("10");
        Attribute length = new Attribute("length", "cm");
        length.setValue("10");
        List<Attribute> attributes = Arrays.asList(width, length);

        Shape result = shapeService.submitShape(new ShapeCategory("RECTANGLE", attributes));
        assertThat(result.getShapeURL()).startsWith("http://service.com/RECTANGLE/");
        assertThat(result.getArea()).isEqualTo(100);
    }

    @Test
    void shouldSubmitCustomShape() {
        given(shapeRepository.isShapeCategoryExist("Hieu")).willReturn(true);

        Attribute attribute = new Attribute("size", "cm");
        attribute.setValue("10");
        List<Attribute> attributes = Arrays.asList(attribute);

        Shape result = shapeService.submitShape(new ShapeCategory("Hieu", attributes));
        assertThat(result.getShapeURL()).startsWith("http://service.com/Hieu/");
        //assertThat(result.getArea()).isEqualTo(0);
    }



    @Test
    void shouldSaveShape() {
        Shape shape = new Shape();
        given(shapeRepository.saveShape(shape)).willReturn(shape);


        Shape result = shapeService.saveShape(shape);
        assertThat(result).isNotNull();
    }

    @Test
    void shouldListSaveShapes() {

        List<Shape> savedShapes = new ArrayList<>();
        given(shapeRepository.getShapes()).willReturn(savedShapes);

        List<Shape> shapes = shapeService.listSaveShapes();

        assertThat(shapes).isEqualTo(savedShapes);
    }

    @Test
    void shouldAddShapeCategory() {
        ShapeCategory category = new ShapeCategory("test", null);

        shapeService.addShapeCategory(category);
        verify(shapeRepository, times(1)).addShapeCategory(category);
    }

    @Test
    void shouldGetAllShapeCategories() {
        List<ShapeCategory> categories = new ArrayList<>();

        given(shapeRepository.getAllShapeCategories()).willReturn(categories);

        List<ShapeCategory> allShapeCategories = shapeService.getAllShapeCategories();
        assertThat(allShapeCategories).isEqualTo(categories);

    }

    @Test
    void shouldListSaveShapesForKid() {
        List<Shape> shapes = new ArrayList<>();

        given(shapeRepository.selectSaveShapesForKid("test")).willReturn(shapes);


        List<Shape> result = shapeService.listSaveShapesForKid("test");
        assertThat(result).isEqualTo(shapes);
    }

    @Test
    void shouldCreateShapeForKid() {
        Shape shape = new Shape();

        given(shapeRepository.insertShapeForKid("test", shape)).willReturn(shape);
        Shape result = shapeService.createShapeForKid("test", shape);

        assertThat(result).isEqualTo(shape);
    }

    @Test
    void shouldUpdateShapeForKid() {
        Shape shape = new Shape();
        given(shapeRepository.updateShapeForKid("test", shape, "1234")).willReturn(shape);

        Shape result = shapeService.updateShapeForKid("test", shape, "1234");
        assertThat(result).isEqualTo(shape);
    }

    @Test
    void shouldDeleteShapeForKid() {
        shapeService.deleteShapeForKid("test", "1234");

        verify(shapeRepository, times(1)).deleteShapeForKid("test", "1234");
    }
}