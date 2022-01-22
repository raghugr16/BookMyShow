package org.rags.bookmyshow.dao;

import org.rags.bookmyshow.entity.BookMyShowApp;
import org.rags.bookmyshow.repository.BookMyShowAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BookMyShowAppDaoImpl implements BookMyShowAppDao{
    @Autowired
    BookMyShowAppRepository bookMyShowAppRepository;

    @Transactional
    @Override
    public BookMyShowApp save(BookMyShowApp bookMyShowApp) {
        BookMyShowApp saved = bookMyShowAppRepository.save(bookMyShowApp);
        return saved;
    }
}
