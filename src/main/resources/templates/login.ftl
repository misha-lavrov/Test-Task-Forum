<#import "macro/common.ftl" as common>
<#import "macro/authentication.ftl" as auth>
<#include "macro/security.ftl">

<@common.htmlPage>
    <#if !known>
    <div class="form-group row align-items-center justify-content-center">
        <div class="mt-5 mb-1">
            Fill out the fields and Sign in
        </div>
    </div>
    </#if>
    <@auth.login "/login" false/>
</@common.htmlPage>