export const useEditableHeader = header => {
  return '🖉' + header
}

export const useIsHeader = type => {
  return type === useWijmoGrid().CellType.ColumnHeader
}

export const useSetImageHeader = header => {
  let _old = header.innerHTML
  return `<img src='/images/grid-header.png' id='img' class="wj-header-image" onClick={this.click} />` + _old
}
