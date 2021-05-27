package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
                .filter((transaction -> transaction.getYear() == 2011))
                //comparing을 사용하여 트랜잭션 값으로 요소 정렬
                .sorted(Comparator.comparing(Transaction::getValue))
                //결과 스트림의 모든 요소를 리스트로 반환
                .collect(toList());


        /**
         * 2.거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
         */
        List<String> collect1 = transactions.stream()
                //트랜잭션과 관련한 각 거래자의 도시 추출
                .map(transaction -> transaction.getTrader().getCity())
                //고유 도시만 출력
                .distinct()
                .collect(toList());

        /**
         * 3.케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
         */
        List<Trader> cambridge = transactions.stream()
                //트랜잭션의 모든 거래자 추출
                .map(Transaction::getTrader)
                //케임브리지의 거래자만 선택
                .filter(trader -> trader.getCity().equals("Cambridge"))
                //중복이 없도록 확인
                .distinct()
                //결과 스트림의 거래자를 이름으로 정렬
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        /**
         * 4.모든 거래자의 이름을 알파벳순으로 정렬해서 반환
         */
        String reduce = transactions.stream()
                //모든 거래자명을 문자열 스트림으로로 추출
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        /**
         * 5.밀라노에 거래자가 있는가?
         */
        boolean isMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        /**
         * 6.케임브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
         */

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        /**
         * 7.전체 트렌잭션 중 최댓값은 얼마인가?
         */
        Optional<Integer> reduce1 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((t1, t2) -> t1 > t2 ? t1 : t2);

        Optional<Integer> reduce2 = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        /**
         * 8.전체 트랜잭션 중 최솟값은 얼마인가?
         */
        Optional<Integer> reduce3 = transactions.stream()
                .map(transaction -> transaction.getValue())
                .reduce((t1, t2) -> t1 < t2 ? t1 : t2);

        boolean seen = false;
        Integer acc = null;
        for (Transaction transaction : transactions) {
            Integer value = transaction.getValue();
            if (!seen) {
                seen = true;
                acc = value;
            } else {
                acc = Integer.min(acc, value);
            }
        }

        Optional<Integer> reduce4 = seen ? Optional.of(acc) : Optional.empty();

    }

}
