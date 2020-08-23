package com.example.kotlinweb.aspect

import com.example.kotlinweb.model.Board
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component


@Aspect
@Component
class BoardAspect(
       private val boardList: MutableList<Board>
){

    @Before(value = "execution(* com.example.kotlinweb.service.BoardService.*(..)) && args(id))")
    fun interceptBoard(joinPoint: JoinPoint, id:Int){
        if(id <= 0) throw RuntimeException("1이상의 숫자를 입력해주세요")
        if(id > boardList.size ) throw RuntimeException("게시글 개수보다 많습니다.")
    }




}
