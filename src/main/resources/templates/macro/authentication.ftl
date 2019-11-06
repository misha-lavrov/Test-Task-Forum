<#include "security.ftl">

<#macro login path isRegisterForm>
<#if known>
<div class="form-group row align-items-center justify-content-center">
    <div class="mt-5 mb-1">
        <h1 class="text-info">
            Hello, ${name}, welcome in this Forum!
        </h1>
    </div>
</div>
<#else>
<form action="${path}" method="post">
    <div class="form-group row align-items-center justify-content-center" >
        <div class="col-sm-4">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row align-items-center justify-content-center">
        <div class="col-sm-4">
            <input type="text" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group row align-items-center justify-content-center">
        <button type="submit" class="btn btn-primary">
            <#if isRegisterForm>Create<#else>Sign In</#if>
        </button>
    </div>
    <div class="form-group row align-items-center justify-content-center">
        <#if !isRegisterForm>
        <a href="/registration">Registration</a>
    </#if>
    </div>
</form>
</#if>

</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-secondary">
        Sign out
    </button>
</form>
</#macro>


