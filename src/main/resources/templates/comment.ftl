<#import "macro/common.ftl" as common>
<#import "macro/add.ftl" as add>

<@common.htmlPage>
<div class="form-group row align-items-center justify-content-center">
    <div class="mt-5 mb-1">
        <b>The comments for the topic: "${topic.name}"</b>
    </div>
</div>
<div class="form-group col align-items-center justify-content-center">
    <#list comments as comment>
        <div class="card mx-auto my-3 w-50 text-center justify-content-center">
            <div class="m-2">${comment.value}</div>
            <div class="card-footer text-muted ">${comment.authorname}</div>
        </div>
    <#else>
    <div class="form-group row align-items-center justify-content-center">
        <div class="mt-5 mb-1">
            <b>No comments</b>
        </div>
    </div>
    </#list>
    <div>
        <div class="form-group row align-items-center justify-content-center">
            <form action="/comment" method="post" class="form-row">
                <input type="hidden" name="id" value="${topic.id}"/>
                <div class="col-sm-10">
                    <input type="text" name="value" class="form-control" placeholder="New comment"/>
                </div>
                <div class="col-sm-2">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </form>
        </div>
    </div>
</div>
</@common.htmlPage>