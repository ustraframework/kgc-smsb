프레임워크에서 제공하는 useWjAccordion 메소드를 사용하여 Panel의 제어를 수행할 수 있다. useWjAccordion 메소드는 Component Reference와 Option 객체를 인자로 수신한다.
```html
<WjAccordion ref="accordionComp" :selectedIndex="selectedIndex" class="mt-5">
  <WjAccordionPane>
    <div>Header1</div>
    <div>
      Header1 <br />
      Content
    </div>
  </WjAccordionPane>
  <WjAccordionPane>
    <div>Header2</div>
    <div>
      Header2 <br />
      Content
    </div>
  </WjAccordionPane>
  <WjAccordionPane>
    <div>Header3</div>
    <div>
      Header3 <br />
      Content
    </div>
  </WjAccordionPane>
</WjAccordion>
<script lang="ts" setup>
const accordionComp = shallowRef()

const accrodion = useWjAccordion(accordionComp, {
  onAfterInitialized(control) {
    control.panes[1].isDisabled = true
  },
})
</script>
```

위의 코드에서 보듯이 onAfterInitialized 옵션을 사용하여 인자 값으로 받은 Accordion 컨트롤 객체를 사용한 제어를 처리할 수 있다. 위의 예제는 어플리케이션이 로드 될 때 2번째 Panel의 상태를 Disabled 상태로 변경하는 예제이다.

Panel의 추가는 useWjAccordion 메소드에서 반환하는 add 메소드를 사용한다. add 메소드는 Header 영역과 Content 영역의 HTML 문자열을 수신한다.
```typescript
function addPanel() {
  accrodion.add(`<div>Header${accrodion.control.panes.length + 1}</div>`, `<div>Header${accrodion.control.panes.length + 1}<br />Content</div>`)
  accrodion.selectedIndex = accrodion.control.panes.length - 1
}
```
위 코드의 addPanel 메소드는 지정된 HTML 문자열의 Panel을 추가하고 선택 index를 추가된 index로 변경하는 예제이다.

add 메소드 외에 insert 메소드를 사용한 제거도 가능하다.
```typescript
function insertPanel() {
  accrodion.insert(0, `<div>Header0</div>`, `<div>Header0<br />Content</div>`)
  accrodion.selectedIndex = 0
}
```

Panel의 제거는 removeAt 메소드를 사용한다. removeAt 메소드는 제거할 index를 파라메터로 수신한다.
```typescript
function removeLastPanel() {
  if (accrodion.control.panes.length > 0) {
    accrodion.removeAt(accrodion.control.panes.length - 1)
  }
}
```
