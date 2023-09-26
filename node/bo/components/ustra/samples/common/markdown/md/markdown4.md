```html
<UMarkdownViewer :content="content" :adjustMarkdownContentBefore="adjustMarkdownContentBefore" 
  :adjustMarkdownContentAfter="adjustMarkdownContentAfter">
</UMarkdownViewer>

<script lang="ts" setup>
const content = `
  # 마크다운 제목
  - 마크다운의 활용 방법 확인
`

/**
 * 마크다운 컨텐츠 변환 전 컨텐츠 조정
 */
function adjustMarkdownContentBefore(content: string) {
  return content
}

/**
 * 마크다운 컨텐츠 변환 후 컨텐츠 조정
 */
function adjustMarkdownContentAfter(content: string) {
  return content
}

</script>
```
