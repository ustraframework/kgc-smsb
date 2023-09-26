CollectionView를 사용하여 변경된 데이터를 추적하는 방법에 대해 안내한다. WjFlexGrid 컴포넌트에 itemsSource 속성을 할당하면 자동으로 CollectionView 객체가 생성된다. CollectionView는 직접 생성하여 itemsSource에 속성에 할당할 수도 있다.

CollectionView는 다음과 같이 생성할 수 있다.
```typescript
// wijmo 라이브러리를 통한 생성
const collectionView = new useWijmo().CollectionView([])

// useCollectionView 메소드를 사용한 Collection View
const collectionView = new useCollectionView([])
```

useWijmoFlexGrid 메소드를 사용할 때는 onAfterInitialized 이벤트 핸들러에서 collectionView를 조회하거나 세팅할 수 있다.
```typescript
const grid = useWijmoFlexGrid({
  onAfterInitialized() {
    const collectionView = grid.collectionView
  }
})
```

만약 그리드에 itemsSource 속성을 설정하지 않았다면 collectionView는 undefined 값이 반환된다.

CollectionView 객체의 trackChanges 속성은 데이터 Row의 추가, 삭제, 수정 Row의 상태를 추적 가능하게 하는 설정이다.
- trackChanges 속성 : https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html#trackchanges

ColectionView에만 설정이 가능하므로 CollectionView를 생성할 때 설정하거나, 조회한 후 세팅이 필요하다.
```typescript
const collectionView = new useWijmo().CollectionView([], {
  trackChanges: true
})
```

useWijmoFlexGrid 메소드는 onAfterInitialized 핸들러 내에서 collectionView를 조회한 후, 변경할 수 있다.
```typescript
const grid = useWijmoFlexGrid({
  onAfterInitialized() {
    grid.collectionView.trackChanges = true
  }
})
```

만약 itemsSource이 초기화 당시 다시 변경되어야 한다면 CollectionView가 다시 생성되므로, 다음과 같이 itemsSourceChanged 이벤트 핸들러를 추가하여 trackChanges 속성을 true로 유지해야 한다.
```typescript
const grid = useWijmoFlexGrid({
  onAfterInitialized() {
    grid.collectionView.trackChanges = true

    grid.rawControl.itemsSourceChanged.addHandler(() => {
      if (grid.collectionView) {
        grid.collectionView.trackChanges = true
      }
    })
  }
})
```
