package com.example.project.servise;

import com.example.project.model.Children;
import com.example.project.repository.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChildrenServiceImpl implements ChildrenService {

    @Autowired
    private ChildrenRepository childrenRepository;

    @Override
    public void addNewChildren(Children newChildren) {
        childrenRepository.save(newChildren);
    }
}
