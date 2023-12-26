import { SmsbFo } from './plugins/smsb-fo';

interface InjectSmsbFo {
  fo: SmsbFo;
}

declare module '@smsb/common/src/plugins/kgc' {
  interface Kgc extends InjectSmsbFo {}
}

export {};
