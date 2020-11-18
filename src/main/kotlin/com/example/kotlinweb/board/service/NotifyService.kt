package com.example.kotlinweb.board.service

import com.example.kotlinweb.board.model.Notify
import com.example.kotlinweb.board.repository.NotifyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class NotifyService(private val notifyRepository: NotifyRepository) {

//    트랜잭션이 이미 커밋되거나 롤백되었지만 트랜잭션 리소스가 여전히 활성화되어 있고 액세스할 수 있을 수 있다.
//    결과적으로, 이 시점에서 트리거된 데이터 액세스 코드는 별도의 트랜잭션에서 실행해야 한다고 명시적으로 선언하지 않는 한,
//    원래 트랜잭션에 여전히 "참여"하여 일부 정리(더 이상 커밋하지 않음!)를 수행할 수 있다.
//    따라서: 여기서 호출되는 모든 트랜잭션 작업에는 REQUIRES_NEW 사용하십시오.

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    fun saveNotify(notify: Notify) {
        notifyRepository.save(notify)
//        throw RuntimeException()
    }

    fun sendNotify(notifyDTO: NotifyDTO) {
        println("Notify Send = $notifyDTO")
    }
}

data class NotifyDTO(
    val message: String,
    val userId: String
)
