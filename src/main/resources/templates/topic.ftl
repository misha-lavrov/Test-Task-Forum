<#import "macro/common.ftl" as common>
<#import "macro/add.ftl" as add>

<@common.htmlPage>
<div class="form-group row align-items-center justify-content-center">
    <div class="mt-5 mb-1">
        <b> The topics of the subject: "${subject.name}"</b>
    </div>
</div>
<div class="form-group col align-items-center justify-content-center">
    <#list topics as topic>
    <div class="card mx-auto my-3 w-50 text-center justify-content-center">
        <a href="/comment?topic_id=${topic.id}">
            <div class="m-2">${topic.name}</div>
            <div class="card-footer text-muted ">${topic.authorname}</div>
        </a>
    </div>
    <#else>
    <div class="form-group row align-items-center justify-content-center">
        <div class="mt-5 mb-1">
            <b>No topics</b>
        </div>
    </div>
</#list>
<div>
    <@add.addNewToDB "/topic" "Topic name" "${subject.id}"/>
</div>
</div>
</@common.htmlPage>
