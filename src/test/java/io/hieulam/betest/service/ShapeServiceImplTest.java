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
    void shouldSubmitShape() {
        given(shapeRepository.isShapeCategoryExist("SQUARE")).willReturn(true);

        Attribute attribute = new Attribute("size", "cm");
        attribute.setValue("10");
        List<Attribute> attributes = Arrays.asList(attribute);

        Shape result = shapeService.submitShape(new ShapeCategory("SQUARE", attributes));
        assertThat(result.getShapeURL()).startsWith("http://service.com/square/");
        assertThat(result.getArea()).isEqualTo(100);
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

}