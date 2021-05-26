package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011,400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012,950)
        );

        /**
         * 1. 2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하십시오.
         */
        List<Transaction> collect = transactions.stream()
                //2011년에 발생한 트랜잭션을 필터링하도록 프레디케이트를 넘겨줌
                .filter((transaction) -> transaction.getYear() == 2011)
                //트랜잭션 값으로 요쇼 정렬
                .sorted(Comparator.comparing(Transaction::getValue))
                //결과 스트림의 모든 요소를 리스트로 반환
                .collect(Collectors.toList());

        /**
         * 2.거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
         */
        List<String> collect1 = transactions.stream()
                //트랜잭션과 관련한 각 거래자의 도시 추출
                .map((transaction -> transaction.getTrader().getCity()))
                //고유 도시만 출력
                .distinct()
                .collect(Collectors.toList());

        /**
         * 3.케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
         */
        List<Trader> collect2 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());



    }
}
