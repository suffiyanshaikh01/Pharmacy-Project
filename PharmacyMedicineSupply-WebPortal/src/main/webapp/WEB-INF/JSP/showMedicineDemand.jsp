<%@ include file="common/header.jspf"%>


<article>
	<div class="container">
		<h1 class="article-heading text-center m-4">Medicine Demand</h1>
			<p style="color: red;text-align: center;">${demandListError}</p>
			<c:if test="${empty demandListError}">
			<table class="table table-striped table-bordered bg-light rounded">
					<thead style="background: #233e8b;">
				<tr class="text-center text-white" style="font-size: 1.3em;">
				
					<th>Medicine</th>
					<th>Demand Count</th>
					<th>Status</th>
				</tr>
			</thead>

			<c:forEach items="${demandList}" var="medicineDemand">
				<tr>
					<td class="col-right">${medicineDemand.medicineName}</td>
					<td class="col-right">${medicineDemand.demandCount}</td>
					<td class="col-right">${medicineDemand.status}</td>
				</tr>

			</c:forEach>

		</table>
		</c:if>
	</div>
</article>


<%@ include file="common/footer.jspf"%>