//package com.example.demo.service;
//
//import lombok.extern.log4j.Log4j;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@Slf4j
//public class SampleTxServiceImpl implements SampleTxService {
//
//
//    private Sample1Mapper mapper1;
//    private Sample2Mapper mapper2;
//
//    @Transactional
//    @Override
//    public void addData(String value) {
//        log.info("mapper1...");
//        mapper1.insertCol1(value);
//        log.info("mapper2...");
//        mapper2.insertCol2(value);
//        log.info("End...");
//    }
//}
