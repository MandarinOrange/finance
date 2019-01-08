package com.example.demo.searchService.service.impl;

import com.example.demo.bean.Product;
import com.example.demo.searchService.repository.ProductRepository;
import com.example.demo.searchService.service.ProductSearchService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public class ProductSearchServiceImpl implements ProductSearchService {
    ProductRepository productRepository = new ProductRepository() {
        @Override
        public List<Product> findByNameLike(String productName) {
            return null;
        }

        @Override
        public List<Product> findAll() {
            return null;
        }

        @Override
        public List<Product> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Product> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Product> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Product> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Product getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends Product> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Optional<Product> findOne(Specification<Product> specification) {
            return Optional.empty();
        }

        @Override
        public List<Product> findAll(Specification<Product> specification) {
            return null;
        }

        @Override
        public Page<Product> findAll(Specification<Product> specification, Pageable pageable) {
            return null;
        }

        @Override
        public List<Product> findAll(Specification<Product> specification, Sort sort) {
            return null;
        }

        @Override
        public long count(Specification<Product> specification) {
            return 0;
        }

        @Override
        public Page<Product> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Product> S save(S s) {
            return null;
        }

        @Override
        public Optional<Product> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(Product product) {

        }

        @Override
        public void deleteAll(Iterable<? extends Product> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Product> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Product> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Product> boolean exists(Example<S> example) {
            return false;
        }
    };
    public List<Product> findByNameLike(String productName){
        List<Product> list = productRepository.findByNameLike(productName);
        return list;
    }
}
