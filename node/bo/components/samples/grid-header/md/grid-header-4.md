```typescript
const itemFormatter = (panel, r, c, cell) => {
  if (useIsHeader(panel.cellType) && (c == 0 || c == 1)) {
    cell.innerHTML = useSetImageHeader(cell);
  }
};
```
CSS는 적용하는 이미지에 따라 사이즈 및 여백값을 설정하여 공통 CSS파일로 맞추어 설정한다.
```css
.iconImage {
  width: 15px;
  height: 15px;
  margin-bottom: -3px;
  margin-right: 2px;
}
```
