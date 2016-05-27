/**
 * 
 */
package com.smartmove.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartmove.domain.common.SmartMoveUser;


/**
 * @author x074395
 *
 */
@Repository
public interface SmartMoveuserRespository extends MongoRepository<SmartMoveUser, String> {
    
}
