package com.example.kotlinweb.board.event

import com.example.kotlinweb.board.model.Notify
import com.example.kotlinweb.board.service.NotifyDTO
import com.example.kotlinweb.board.service.NotifyService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class PostSaveEventHandler(
    private val notifyService: NotifyService
) {
    //    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun postSaveEventListener(event: PostSaveEvent) {
        println("Event Listen")
        notifyService.saveNotify(Notify.of(event.getPostId().toString(), event.getMessage()))
        notifyService.sendNotify(NotifyDTO(event.getMessage(), "0"))
    }
}