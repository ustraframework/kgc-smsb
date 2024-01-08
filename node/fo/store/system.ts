import { defineInitStore } from '#imports';
import { useInitialDataService, Sns } from '~/services/initial-data-service';

/**
 * 시스템 관련 정보 store
 */
export const useSystemStore = defineInitStore(
  'system',
  () => {
    const states = (() => {
      /**
       * 데이터 로드 여부
       */
      const loadedData = ref(false);

      /**
       * 공통 프로퍼티
       */
      const props = ref<Partial<Sns>>({});

      return { loadedData, props };
    })();

    return { ...states };
  },
  async (store, { $ustra }) => {
    // const service = useInitialDataService($ustra.nuxtApp);

    // if (!store.loadedData) {
    //   const initData = await service.getInitData();
    //   store.props = initData.sns;
    //   store.loadedData = true;
    // }
  },
);
