커스톰 팝업 창 등을 사용하기 위해 openDaumPostScreen API를 제공한다.
- API Document : http://guide.ustraframework.kro.kr/docs/node/3.0/nuxt/functions/externals_daum_post.openDaumPostScreen.html
```typescript
import { openDaumPostScreen } from '#ustra/nuxt/externals/daum/post'
```

API Document에서 안내하는대로 주소 검색 화면을 Embed 할 HTMLElement와 DaumPostScreenOptions 유형의 Option 값을 수신하며, DaumPostScreenOptions의 onSelected 속성을 통해 결과 값을 수신 후, 타 컴포넌트로 전달할 수 있다.
커스톰 컴포넌트를 제작하고 openDaumPostScreen을 통해 지정된 영역에 팝업 창을 노출하여 사용자에게 커스톰한 형태의 UI를 제공할 수 있다.
```typescript
const emits = defineEmits<{
  (e: 'selected', data: DaumPostResult): void
}>()

openDaumPostScreen(el, {
  onSelected(data) {
    emits('selected', data)
  },
})
```
다음은 UDaumPostPopup 컴포넌트의 전체 소스코드이다. 해당 코드를 참고하여 커스톰한 주소창 팝업을 만들어 보도록 하자.
```html
<template>
  <slot :modelValue="modelValue" :onUpdate:modelValue="value => (modelValue = value)" :loadZipContainer="loadZipContainer">
    <UPopup v-model="modelValue" :width="800" :height="600" title="우편번호 조회" @shown="() => loadZipContainer()">
      <div ref="zipContianerEl" style="width: 100%; height: 100%"></div>
    </UPopup>
  </slot>
</template>
<script lang="ts" setup>
import { useHead } from '#app'
import { ref } from '#ustra/nuxt'
import { useVModel } from '@vueuse/core'
import toNumber from 'lodash/toNumber'
import UPopup from '../dialog/u-popup.vue'
import { openDaumPostScreen, DaumPostResult, DaumPostScreenOptions } from '#ustra/nuxt/externals/daum/post'

const props = withDefaults(defineProps<Props>(), {
  options: () => {
    return {}
  },
  addLatLng: false,
  apiKey: () => {
    return $ustra.components.getComponentsOption('UDaumPostPopup').apiKey
  },
})
const emits = defineEmits<Emits>()

const zipContianerEl = ref<HTMLDivElement>()
const { modelValue, loadZipContainer } = useDaumPostPopup({
  zipContianerEl,
  emits,
  props,
})

//#region load scripts
const scripts = [{ key: 'daumPostMapScript', src: '//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js' }]
if (props.addLatLng) {
  scripts.push({ key: 'kakaoMapScript', src: `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${props.apiKey}&libraries=services` })
}
//#endregion

useHead({
  script: scripts,
})
</script>
<script lang="ts">
import { Ref } from '#ustra/nuxt'

export interface Props {
  /**
   * 팝업 오픈 여부
   */
  modelValue: boolean

  /**
   * Daum Post 창 옵션
   */
  options?: DaumPostScreenOptions

  /**
   * 위경도를 표시한다. apikey가 반드시 존재해야 한다.
   * @default false
   */
  addLatLng?: boolean

  /**
   * addLatLng가 true일 경우, API 통신 키 값
   */
  apiKey?: string
}

export interface Emits {
  (e: 'selected', data: DaumPostResult): void
  (e: 'update:modelValue', value: boolean): void
}

/**
 * Daum Post Popup 컴포넌트
 * @param options
 *  - props : 컴포넌트 Props
 *  - emits : 컴포넌트 emits
 *  - zipContainerEl : 주소 창을 로드할 HTMLElement
 *  - convertResultHandler : 주소 검색 결과를 변경할 Method
 */
export const useDaumPostPopup = (options: {
  /**
   * 컴포넌트 프로퍼티
   */
  props: Props

  /**
   * 컴포넌트 emit 객체
   */
  emits: Emits

  /**
   * 주소창을 로드할 Element
   */
  zipContianerEl?: Ref<HTMLElement>

  /**
   * 결과 값을 변경할 Handler Function
   */
  convertResultHandler?: (result: DaumPostResult) => DaumPostResult
}) => {
  if (options.props.addLatLng && !options.props.apiKey) {
    throw new Error('apiKey가 설정되지 않았습니다.')
  }

  const modelValue = useVModel(options.props, 'modelValue')

  function convertResult(result: DaumPostResult) {
    if (options.convertResultHandler) {
      return options.convertResultHandler(result)
    }

    return result
  }

  /**
   * 우편번호 화면을 로드한다.
   * @param zipContianerEl 화면을 로드할 Element
   */
  function loadZipContainer(zipContianerEl?: HTMLElement) {
    if (zipContianerEl) {
      options.zipContianerEl = ref(zipContianerEl)
    }

    $ustra.utils.core
      .getObjectAsync(() => options.zipContianerEl.value)
      .then(zipContianerEl => {
        openDaumPostScreen(zipContianerEl, {
          ...options.props.options,
          onSelected(data) {
            // 좌표 조회
            if (options.props.addLatLng) {
              $ustra.global.kakao.maps.load(() => {
                const geocoder = new $ustra.global.kakao.maps.services.Geocoder()

                geocoder.addressSearch(data.address, (results, status) => {
                  if (status === $ustra.global.kakao.maps.services.Status.OK && results.length > 0) {
                    data.lat = toNumber(results[0].x)
                    data.lng = toNumber(results[0].y)
                    options.emits('selected', convertResult(data))
                    modelValue.value = false
                    return
                  }

                  options.emits('selected', convertResult(data))
                  modelValue.value = false
                  return
                })
              })

              return
            }

            options.emits('selected', convertResult(data))
            modelValue.value = false
          },
        })
      })
  }

  return { modelValue, loadZipContainer }
}

export default {
  name: 'UDaumPostPopup',
}
</script>
```

UDaumPostPopup은 위의 코드와 같이 slot과 useDaumPostPopup 를 통한 확장을 지원한다. 
먼저 slot을 사용한 확장은 다음과 같이 작성할 수 있다.
```html
<template>
  <UDaumPostPopup
    v-bind="props"
    v-model="modelValue"
    @selected="
      result => {
        $emit('selected', result)
        modelValue = false
      }
    "
  >
    <template #default="{ loadZipContainer, modelValue, 'onUpdate:modelValue': onUpdateModelValue }">
      <UPopup
        :modelValue="modelValue"
        @update:modelValue="onUpdateModelValue"
        :width="800"
        :height="600"
        title="Custom 우편번호 조회"
        @shown="() => loadZipContainer(zipContianerEl)"
      >
        <div ref="zipContianerEl" style="width: 100%; height: 100%"></div>
      </UPopup>
    </template>
  </UDaumPostPopup>
</template>
<script lang="ts" setup>
import { UDaumPostPopup } from '#components'
import { Props } from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'

const props = defineProps<Props>()
const modelValue = useVModel(props, 'modelValue')
const zipContianerEl = ref<HTMLElement>()
</script>
<script lang="ts">
export default {
  inheritAttrs: false,
}
</script>
```
이벤트의 경우, props로 선언되지 않았으므로 inheritAttrs 기본 설정에 의해 UDaumPostPopup에 전달되게 되어 이벤트가 bypass 되도록 처리되는데 이를 방지하려면 inheritAttrs 설정을 false로 세팅해야 한다.

ref 설정 또한 상위 컴포넌트에서는 감지가 불가능하므로 loadZipContainer 메소드에서는 HTMLElement를 수신하여 주소 창을 렌더링하는 DOM으로 사용하도록 처리한다.

API를 사용한 커스토마이징은 아래와 같다.
```html
<template>
  <UPopup v-model="modelValue" :width="800" :height="600" title="커스톰 우편번호 조회 (신규 컴포넌트 생성)" @shown="() => loadZipContainer()">
    <div ref="zipContianerEl" style="width: 100%; height: 100%"></div>
  </UPopup>
</template>
<script lang="ts" setup>
import { Props, Emits, useDaumPostPopup } from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'

const props = withDefaults(defineProps<Props>(), {
  options: () => {
    return {}
  },
  addLatLng: false,
  apiKey: () => {
    return $ustra.components.getComponentsOption('CDaumPostPopup').apiKey
  },
})
const emits = defineEmits<Emits>()

const zipContianerEl = ref<HTMLElement>()
const { modelValue, loadZipContainer } = useDaumPostPopup({
  props,
  emits,
  zipContianerEl,
})
</script>
```

컴포넌트의 변수 및 동작 제어를 위해 useDaumPostPopup 메소드를 통해 반환되는 변수와 메소드를 사용하여 구성할 수 있으며, useDaumPostPopup 에서 제공되는 옵션에 따라서 확장된 기능을 제공할 수 있다.
