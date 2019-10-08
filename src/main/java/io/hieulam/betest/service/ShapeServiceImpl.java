package io.hieulam.betest.service;

import io.hieulam.betest.model.Shape;
import io.hieulam.betest.model.ShapeCategory;
import io.hieulam.betest.repository.ShapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {

    @Autowired
    ShapeRepository shapeRepository;

    @Override
    public List<ShapeCategory> listShapeCategories() {
        return shapeRepository.getAllShapeCategories();
    }

    @Override
    public Shape submitShape() {
        return null;
    }

    @Override
    public Shape saveShape() {
        return null;
    }

    @Override
    public Shape listSaveShapes() {
        return null;
    }
}
