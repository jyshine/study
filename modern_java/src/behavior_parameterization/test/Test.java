package behavior_parameterization.test;

import java.util.ArrayList;
import java.util.List;


public class Test {
    /**
     * 녹새 사과를 필터링
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if(ColorEnum.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *  => 갑자기 녹생 뿐만 아니라 빨간색도 필터링 하고 싶어 졌을 경우가 필요해졌다.
     *  => 위와 같은 방법으로 처리할 경우 filterRedApples 메소드를 만들어야한다.
     *  => 코드를 반복 사용하지 않고 유연한 코드로 변경한다.
     */

    public static List<Apple> filterApplesByColor(List<Apple> inventory, ColorEnum colorEnum){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (apple.getColor().equals(colorEnum)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *  => 색 말고 무게에 대한 필터가 필요해졌다.
     */

    public static List<Apple> filterApplesByWeight(List<Apple> inventory,int weight){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *  => 필터 조건이 추가되면 색 필터링 코드와 중복되는 코드들을 작성해야한다.
     *  => DRY Don not repeat yourself 원칙에 어긋난다.
     *  => 색과 무게를 필러하는 메소드로 합친다 하더라도 어떤 기준으로 필터링할지 구분 값과 처리가 필요하다.
     */

    public static List<Apple> filterApplesByColorAndWeight(List<Apple> inventory,ColorEnum colorEnum, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if ((flag && apple.getColor().equals(colorEnum)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     *  => 매개 변수가 지저분하고 조건도 길어져 보기 가독성이 좋지 않다.
     *  => 지금까지 문자열, 정수, 불리언 등의 값으로 filterApples 메서드를 파라미터화 했다.
     *  => filterApples에 어떤 기준으로 사과를 필터링할 것인지 효과적으로 전달할 수 있다면 좋을 것 같다.
     *
     *  => 동작 파라미터화를 이용해서 유연성을 얻는 방법으로 해결할 수 있다.
     *  => 우리의 선택 조건을 다음처럼 결정할 수 있다.
     *  => 사과의 어떤 속성에 기초해서 불리언 값을 반환(사과 색, 무게)
     *  => 참 또는 거짓을 반환하는 함수를 프레디케이트.
     *  => 선택 조건을 결정하는 인터페이스 정의.
     *  => ApplePredicate 인터페이스 생성.
     *  => 선택 조건을 대표하는 버전 ApplePredicate 정
     *  => AppleGreenColorPredicate, AppleHeavyWeightPredicate 구현
     *  => 전략 디자인 패턴 strategy design pattern : 알고리즘을 캡슐화하는 알고리즘 패밀리를 정의해둔 다음에 런다임에 알고리즘을 선택.
     *  => 동작 파라미터화, 즉 메서드가 다양한 동작을 받아서 내부적으로 다양한 동작을 수행할 수 있다.
     *
     */
    public static List<Apple> filterApplesPredicate(List<Apple>  inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory){
            if (p.applePredicate(apple)){ //프레디케이트 객체로 사과 검사 조건을 캡슐화했다.
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * => 필터 메서드에 전략 전달. ApplePredicate를 객체로 캡슐화된 불리언 표현식을 이용해서 필터링할 수 있다.
     * => 한 개의 파라미터에 다양한 동작이 가능하겠끔 했다.
     *
     * => 하지만 객체로 감싸서 전달해야하는 단점이 있다.
     * => 익명 함수로 메서드의 동작을 직접 파리미터화
     *
     */

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(ColorEnum.GREEN,100));
        inventory.add(new Apple(ColorEnum.RED,200));
        inventory.add(new Apple(ColorEnum.RED,140));
        inventory.add(new Apple(ColorEnum.RED,150));
        inventory.add(new Apple(ColorEnum.GREEN,300));


//        List<Apple> result = filterGreenApples(inventory); //녹색 사과만 필터링
//        List<Apple> result = filterApplesByColor(inventory,ColorEnum.RED); //필터링 색을 받아서 필터링
//        List<Apple> result = filterApplesByWeight(inventory,120); //필터링 색을 받아서 필터링
//        List<Apple> result = filterApplesByColorAndWeight(inventory,null,120, false); //필터링을 합쳤다.


        //동작을 파라미터화하고 다양한 필터 전략
//        List<Apple> result = filterApplesPredicate(inventory, new AppleGreenColorPredicate());
//        List<Apple> result = filterApplesPredicate(inventory, new AppleHeavyWeightPredicate());
//        List<Apple> result = filterApplesPredicate(inventory, new AppleRedAndHeavyPredicate());

        //익명 함수로 메서드의 동작을 직접 파리미터화
        List<Apple> result = filterApplesPredicate(inventory, new ApplePredicate() {
            @Override
            public boolean applePredicate(Apple apple) {
                return ColorEnum.RED.equals(apple.getColor());
            }
        });



        for (Apple apple : result){
            System.out.println(apple.toString());
        }
    }
}
