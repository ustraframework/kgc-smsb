$ustra.utils.component.mount 메소드를 사용하여 컴포넌트를 동적으로 mount 할 수 있다. mount 메소드의 원형은 다음과 같다.
```typescript
mount(component: any, instance: ComponentInternalInstance, { props, children, element }?: {
    props?: any;
    children?: any;
    element?: any;
}): {
    vNode: VNode<RendererNode, RendererElement, {
        [key: string]: any;
    }>;
    destroy: () => void;
    el: any;
}
```
mount 메소드는 다음과 같은 인자 값을 수신받는다.
| 명 | 설명 | 
| --- | --- | 
| component | 렌더링할 컴포넌트 객체 |
| instance | 렌더링을 호출하는 컴포넌트 Instance. getCurrentInstance 메소드로 추출한다. |
| componentOption | 컴포넌트를 렌더링하는 옵션을 설정한다.<br />- props: 속성을 object 형태로 정의<br />- children: 렌더링할 슬롯 Object<br />- element: 렌더링 대상의 Element |

또한 mount 메소드를 호출하면 다음과 같은 객체를 반환한다.
| 명 | 유형 | 설명 | 
| --- | --- | --- | 
| vNode | VNode | VNode 객체 | 
| destroy | () => void | 컴포넌트를 제거하는 function | 
| el | Element | 컴포넌트가 렌더링된 element | 

컴포넌트의 Instance 및 속성에 접근하기 위해서는 vNode 객체를 사용하고, destroy 메소드를 사용하여 컴포넌트를 제거할 수 있다. 아래 예제를 보면 UButton 컴포넌트를 동적으로 생성하여 렌더링하고 Destroy 버튼을 클릭하면 생성된 컴포넌트를 제거한다.
