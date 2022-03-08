package com.codegym.service;

import java.util.List;

public interface IGeneralService <T> {// chứa các phương thức chung: hiển thị, thêm mới, xoá...
    // Hiển thị danh sách
    List<T> findAll();
    // Tìm kiếm theo id
    T findById(int id);
    //
    void create (T t);
    //
    void updateById(int id, T t);
    //
    void deleteById(int id);

}

