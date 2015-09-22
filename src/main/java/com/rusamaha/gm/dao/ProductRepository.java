package com.rusamaha.gm.dao;

        import com.rusamaha.gm.model.ProductBase;
        import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mary on 23.02.2015.
 */

public interface ProductRepository extends CrudRepository<ProductBase, Long>, ProductRepositoryCustom {

//    @Procedure
//    @Transactional
//    public Long saveProduct(@Param("NAME") String name,
//                            @Param("KNIT_TECHNOLOGY") String knitTechnology,
//                            @Param("CATEGORY_CATEGORY_ID") Long categoryID,
//                            @Param("AVAILABILITY") Boolean availability
////                            , @Param("ID") Long productID
//                        );


}
