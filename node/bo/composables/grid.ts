import { ref, watch, ShallowRef, computed } from '#ustra/nuxt'
import { Selector } from '@grapecity/wijmo.grid.selector'
import { DataMap, FlexGrid, Row, SelectionMode, HitTestInfo } from '@grapecity/wijmo.grid'

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

/**
 * WijmoFlexGrid CheckBox Selection Rows
 * @param gridControl grid control
 * @returns
 *  - selector : selector object
 *  - selectionRows : selection Rows object
 *  - selectionRowData : selection Rows data list
 */
export const useWjGridCheckBoxSelection = <T = any>(gridControl: ShallowRef<FlexGrid>, isSingle = false) => {
  let selector: Selector = null
  const selectionRows = ref<Row[]>()
  selectionRows.value = []

  const selectionRowData = computed(() => {
    return selectionRows.value.map(r => r.dataItem) as T[]
  })

  watch(
    gridControl,
    v => {
      if (v) {
        selector = new Selector(v, {
          itemChecked: () => {
            selectionRows.value = v.rows.filter(r => r.isSelected)
          },
        })
        selector.column = gridControl.value.rowHeaders.columns[0]
        v.selectionMode = SelectionMode.Row
      }
    },
    {
      immediate: true,
    },
  )

  return { selectionRows, selector, selectionRowData }
}
