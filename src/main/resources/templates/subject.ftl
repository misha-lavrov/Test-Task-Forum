<#import "macro/common.ftl" as common>
<#import "macro/add.ftl" as add>

<@common.htmlPage>
<div class="form-group row align-items-center justify-content-center">
    <div class="mt-5 mb-1">
        <b>The forum subject list:</b>
    </div>
</div>
<div class="form-group col align-items-center justify-content-center">
    <#list subjects as subject>
    <div class="card mx-auto my-3 w-50 text-center justify-content-center">
        <a href="/topic?subject_id=${subject.id}">
            <div class="m-2">${subject.name}</div>
            <div class="card-footer text-muted ">${subject.authorname}</div>
        </a>
    </div>
    <#else>
    <div class="form-group row align-items-center justify-content-center">
        <div class="mt-5 mb-1">
            <b>No subjects</b>
        </div>
    </div>
    </#list>
    <div>
        <@add.addNewToDB "/subject" "Subject name" ""/>
    </div>
</div>
</@common.htmlPage>