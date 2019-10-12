package io.hieulam.betest.repository;

import io.hieulam.betest.model.Attribute;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.model.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


public class ShapeRepositoryImplTest {

    private ShapeRepository shapeRepository;

    @Before
    public void setUp() {
        shapeRepository = new ShapeRepositoryImpl();
    }

    @Test
    public void shouldGetAllShapeCategories() {
        List<ShapeCategory> result = shapeRepository.getAllShapeCategories();
        assertThat(result.size()).isEqualTo(3);

    }

    @Test
    public void shouldSaveShape() {
        List<Shape> shapes = shapeRepository.getShapes();
        assertThat(shapes.size()).isEqualTo(0);

        Shape shape = new Shape();
        shape.setId(UUID.randomUUID());
        shape.setAttributes(Arrays.asList(new Attribute(), new Attribute()));
        shapeRepository.saveShape(shape);

        shapes = shapeRepository.getShapes();
        assertThat(shapes.size()).isEqualTo(1);
    }

    @Test
    public void shouldGetShapes() {
        List<Shape> shapes = shapeRepository.getShapes();
        assertThat(shapes.size()).isEqualTo(0);

        Shape shape = new Shape();
        shape.setId(UUID.randomUUID());
        shape.setAttributes(Arrays.asList(new Attribute(), new Attribute()));
        shapeRepository.saveShape(shape);

        shapes = shapeRepository.getShapes();
        assertThat(shapes.size()).isEqualTo(1);
    }

    @Test
    public void shouldAddShapeCategory() {

        List<ShapeCategory> allShapeCategories = shapeRepository.getAllShapeCategories();
        assertThat(allShapeCategories.size()).isEqualTo(3);

        List<Attribute> requirements = Arrays.asList(new Attribute(), new Attribute());
        ShapeCategory category = new ShapeCategory("New Category", requirements);

        shapeRepository.addShapeCategory(category);

        allShapeCategories = shapeRepository.getAllShapeCategories();

        assertThat(allShapeCategories.size()).isEqualTo(4);
    }

    @Test
    public void shouldCheckShapeCategoryExist() {
        boolean isExist = shapeRepository.isShapeCategoryExist("TRIANGLE");
        assertThat(isExist).isEqualTo(true);

    }
}