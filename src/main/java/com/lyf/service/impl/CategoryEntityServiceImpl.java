package com.lyf.service.impl;

import com.lyf.entity.CategoryEntity;
import com.lyf.mapper.CategoryEntityMapper;
import com.lyf.service.CategoryEntityService;
import com.lyf.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: codepractice
 * @description:
 * @author: 刘耀福
 * @create: 2024-03-16 12:46
 **/
@Service
public class CategoryEntityServiceImpl implements CategoryEntityService {
    @Autowired
    private CategoryEntityMapper categoryEntityMapper;

    @Override
    public R getData() {
        long startTime = System.currentTimeMillis();
        List<CategoryEntity> entities = categoryEntityMapper.getList();
        //2.组装成父子的树形结构
        //2.1 找到所有的一级分类
        List<CategoryEntity> level1Menus = entities
                .stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map((menu) -> {
                    menu.setChildren(getChildrens(menu, entities));
                    return menu;
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return R.ok(level1Menus);
    }

    private List<CategoryEntity> getChildrens(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter(categoryEntity -> categoryEntity.getParentCid() == (root.getCatId())).map(categoryEntity -> {
            //找子菜单
            categoryEntity.setChildren(getChildrens(categoryEntity, all));
            return categoryEntity;
        }).sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort()))).collect(Collectors.toList());
        return children;
    }


    @Override
    public R getData1() {
        long startTime = System.currentTimeMillis();
        List<CategoryEntity> all = categoryEntityMapper.getList();
        List<CategoryEntity> levelOneCategoryEntities = all.stream().filter(item -> 1 == item.getCatLevel()).collect(Collectors.toList());
        List<CategoryEntity> levelTwoCategoryEntities = all.stream().filter(item -> 2 == item.getCatLevel()).collect(Collectors.toList());
        List<CategoryEntity> levelThreeCategoryEntities = all.stream().filter(item -> 3 == item.getCatLevel()).collect(Collectors.toList());
        //查询二级、三级分类
        for (CategoryEntity levelOne : levelOneCategoryEntities) {
            List<CategoryEntity> child = new ArrayList<>();
            for (CategoryEntity levelTwo : levelTwoCategoryEntities) {
                if (levelOne.getCatId().equals(levelTwo.getParentCid())) {
                    List<CategoryEntity> child2 = new ArrayList<>();
                    for (CategoryEntity three : levelThreeCategoryEntities) {
                        if (levelTwo.getCatId().equals(three.getParentCid())) {
                            child2.add(three);
                        }
                    }
                    levelTwo.setChildren(child2);
                }
                child.add(levelTwo);
            }
            levelOne.setChildren(child);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return R.ok(levelOneCategoryEntities);
    }


    @Override
    public R getData2() {
        long startTime = System.currentTimeMillis();
        Long parentCid = 0L;
        //查询一级分类
        List<CategoryEntity> levelOneCategoryEntities = getXxx(parentCid);
        //查询二级、三级分类
        for (CategoryEntity levelOne : levelOneCategoryEntities) {
            List<CategoryEntity> levelTwoCategoryEntities = getXxx(levelOne.getCatId());
            levelOne.setChildren(levelTwoCategoryEntities);
            for (CategoryEntity levelTwo : levelTwoCategoryEntities) {
                List<CategoryEntity> levelThreeCategoryEntities = getXxx(levelTwo.getCatId());
                levelTwo.setChildren(levelThreeCategoryEntities);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime));
        return R.ok(levelOneCategoryEntities);
    }


    public List<CategoryEntity> getXxx(Long parentCid) {
        List<CategoryEntity> all = categoryEntityMapper.getList();
        List<CategoryEntity> levelOneCategoryEntities = all.stream().filter(item -> parentCid.equals(item.getParentCid())).collect(Collectors.toList());
        return levelOneCategoryEntities;
    }
}
