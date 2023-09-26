```html
<ULayout>
  <UBox>
    <UItem cols="8">
      <UBox>
        <UItem>
          <div style="padding: 0 0.5rem">
            <WjFlexGrid :itemsSource="data" style="height: 300px">
              <WjFlexGridColumn :header="'Country'" :binding="'country'" width="*" />
              <WjFlexGridColumn :header="'Sales'" :binding="'sales'" width="*" format="n2" />
            </WjFlexGrid></div
        ></UItem>
      </UBox>
    </UItem>
    <UItem cols="4">
      <UBox>
        <UItem>
          <div style="padding: 0 0.5rem">
            <WjFlexGrid :itemsSource="data" style="height: 300px">
              <WjFlexGridColumn :header="'Country'" :binding="'country'" />
              <WjFlexGridColumn :header="'Sales'" :binding="'sales'" format="n2" />
            </WjFlexGrid></div
        ></UItem>
      </UBox>
    </UItem>
  </UBox>
</ULayout>
```
