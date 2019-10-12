package io.hieulam.betest.service;

import io.hieulam.betest.model.shape.Shape;
import io.hieulam.betest.repository.ShapeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

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
    void submitShape() {


    }

    @Test
    void saveShape() {
        Shape shape = new Shape();
        given(shapeRepository.saveShape(shape)).willReturn(shape);


        Shape result = shapeService.saveShape(shape);
        assertThat(result).isNotNull();
    }

    @Test
    void listSaveShapes() {
    }

    @Test
    void addShapeCategory() {
    }

    @Test
    void getAllShapeCategories() {
    }

    @Test
    void submitShape1() {
    }

    @Test
    void saveShape1() {
    }

    @Test
    void listSaveShapes1() {
    }

    @Test
    void addShapeCategory1() {
    }

    @Test
    void getAllShapeCategories1() {
    }
}