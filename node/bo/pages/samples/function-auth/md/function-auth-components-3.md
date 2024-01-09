```javascript
const result = await service.getOrdClaimList({
...searchParam,
pageSize,
pageNo: currentPage,
});

usePrivacyHistory().addFunctionAccessHistory( 'basicSearch', result)
```

```javascript
async function getClaim(clmId: string, option: ApiOriginOptions = {}, showLoadingBar: boolean = true) {
    const res = await api.call<apiModels.ApiResponse<ClmClaimDetailModel>>({
        ...option,
        url: `/api/bo/clm/${clmId}`,
        method: 'GET',
        showLoadingBar,
    })

    const privacyHistory = usePrivacyHistory()
    privacyHistory.mergeProcIdAndReqId(res)

    return res.data
}
```
