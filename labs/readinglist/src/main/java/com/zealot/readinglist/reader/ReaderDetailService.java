package com.zealot.readinglist.reader;

import com.zealot.readinglist.database.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ReaderDetailService implements UserDetailsService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public UserDetails loadUserByUsername(String readername) {
        Reader reader = readerRepository.findByUsername(readername);
        if (reader == null) {
            throw new UsernameNotFoundException(readername);
        }
        return new ReaderDetails(reader);
    }
}