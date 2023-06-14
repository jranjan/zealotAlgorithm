package com.zealot.readinglist.database;

import com.zealot.readinglist.reader.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
    Reader findByUsername(String readername);
}