export const useFunctionAuthCheck = functionId => {
  const currentMenuId = $ustra.management.store.navigation.currentProgramMenu.mnuId

  let authData = false
  if ($ustra.management.auth.hasMenuAuthority(currentMenuId)) {
    $ustra.auth.store.roles.forEach(async role => {
      if (role.split(':')[0] === currentMenuId && role.split(':')[2] === functionId) {
        authData = true
      }
    })
  }
  return authData
}
