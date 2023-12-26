import { defineNuxtPlugin, NuxtApp, createError, showError, abortNavigation } from '#app';
import { useUstra } from '#ustra/nuxt/composables/ustra';
import { useSystemStore } from '~/store/system';

export class SmsbFo {
  private _systemStore: Awaited<ReturnType<typeof useSystemStore>>;

  constructor(private nuxtApp: NuxtApp) {}

  async init() {
    this._systemStore = await useSystemStore();
  }

  get store() {
    return {
      system: this._systemStore,
    };
  }
}

export default defineNuxtPlugin(async nuxt => {
  const $ustra = useUstra();
  $ustra.logger.info('register kgc-fo plugin');

  const kgc = useKgc();
  const smsbFo = new SmsbFo(nuxt as NuxtApp);
  await smsbFo.init();

  kgc['fo'] = smsbFo;
});
