```html
<ULayout>
  <UBox>
    <UItem
      ><div style="padding: 0 0.5rem">
        <WjFlexGrid :itemsSource="data" style="height: 150px">
          <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
          <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        </WjFlexGrid></div
    ></UItem>
  </UBox>
  <UBox>
    <UItem
      ><div style="padding: 0 0.5rem">
        <WjFlexGrid :itemsSource="data" style="height: 200px">
          <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
          <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
        </WjFlexGrid></div
    ></UItem>
  </UBox>
</ULayout>
```
