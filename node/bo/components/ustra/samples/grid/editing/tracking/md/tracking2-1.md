CollecitonView에 바인딩 된 데이터를 직접 수정하게 되면 데이터의 추적이 되지 않는다. 이 때 사용할 수 있는 것이 editItem 메소드이다. editItem 메소드는 수정 row object 정보를 인자 값으로 받으며 해당 row가 수정된 것을 추적 가능하게 하는 메소드이다.

- editItem : https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html#edititem
- commiEdit : https://www.grapecity.com/wijmo/api/classes/wijmo.collectionview.html#commitedit

<br />
editItem 호출 이후에는 commitEdit 메소드를 호출하여 변경 완료된 사항을 반드시 저장해야 한다.

```typescript
for (let i = 0; i < data.value.length; i++) {
  grid.collectionView.editItem(data)
  
  data.value[i].data1 = Math.random() * 1000
  data.value[i].data2 = Math.random() * 1000
  data.value[i].data3 = Math.random() * 1000
  data.value[i].data4 = Math.random() * 1000
  
}
grid.collectionView.commitEdit()
```

editItem 메소드는 데이터의 트랜잭션을 시작하는 메소드이며, 데이터가 변경되기 전에 호출해야 한다. 모든 데이터의 변경 후에는 반드시 commitEdit 메소드를 호출한다.

아래 예제는 데이터를 editItem 메소드와 commitEdit 메소드를 사용하여 수동 변경하고 데이터의 추적여부를 확인하는 예제이다.
