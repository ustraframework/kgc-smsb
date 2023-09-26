Combo Box의 선택 값은 v-model을 사용하거나 Combo Box Control 객체의 selectedValue 값을 사용할 수 있다.
단, v-model 값과 selectedValue 값은 다를 수 있는데 이는 초기에는 해당 값이 동일하게 세팅되지 않기 때문이다.
이럴 경우는 v-model에 바인딩 된 값을 현재 세팅된 값과 맞추어 세팅하거나 initialized 속성에서 변수 동기화를 수행해야 한다.
