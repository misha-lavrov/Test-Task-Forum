<#import "macro/common.ftl" as common>
<#import "macro/authentication.ftl" as auth>

<@common.htmlPage>
    <div class="form-group row align-items-center justify-content-center">
        <div class="mt-5 mb-1">
            New user registration
        </div>
    </div>
    <@auth.login "/registration" true/>
</@common.htmlPage>