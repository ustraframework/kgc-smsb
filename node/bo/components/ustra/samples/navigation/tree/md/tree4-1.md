useWijmoTreeView 메소드를 사용하여 WjTreeView 컴포넌트를 쉽게 컨트롤 할 수 있다. useWijmoTreeView는 UseWijmoTreeOptions 값을 인자로 받으며 UseWijmoTreeOptions는 다음과 같은 옵션을 설정할 수 있다.

| 명 | 유형 | 설명 | default |
| --- | --- | --- | --- |
| useCheckSelection | boolean | check box 선택 기능 사용 여부 | false |
| onAfterInitialized | (control: TreeView) => void ｜ Promise<void> | 컨트롤 초기화 후, callback |  |
| onDblClick | (data: Data, e: MouseEvent) => void ｜ Promise<void> | 아이템 더블클릭 시, callback |  |


useWijmoTreeView 메소드는 object 결과를 반환하며 각 속성은 다음과 같다.
| 명 | 유형 | 설명 | 
| --- | --- | --- | 
| options | UseWijmoTreeOptions | 설정 옵션 값 | 
| initialize | Function | 초기화 Function | 
| control | ShallowRef<TreeView> | TreeView 객체 (https://www.grapecity.com/wijmo/api/classes/wijmo_nav.treeview.html) | 
| rawControl | TreeView | Wrapping되지 않은 TreeView 객체 | 
| expandAll | () => void | Tree Node를 모두 expand 하는 메소드 | 
| collapseAll | () => void | Tree Node를 모두 collapse 하는 메소드 | 
| selectedItem | Data | 선택된 아이템 | 
| checkedItems | Data[] | 체크된 아이템 목록 | 

useWijmoTreeView 메소드는 다음과 같이 사용한다.
```typescript
const treeView = useWijmoTreeView({
  onAfterInitialized() {
    // treeview의 속성 변경
    treeView.rawControl.expandOnClick = false

    // 모두 다 펼치기
    treeView.expandAll()
  }
})

// 바인딩 데이터의 특정 유형 지정
interface NodeData {
 ...
}

const treeView = useWijmoTreeView<NodeData>()
```

위와 같이 정의된 treeView 변수에서 반환된 initialize 메소드는 컴포넌트의 initialized 속성과 매핑해야 한다.
```html
<WjTreeView :initialized="ctl => (treeView = ctl)" />
```
