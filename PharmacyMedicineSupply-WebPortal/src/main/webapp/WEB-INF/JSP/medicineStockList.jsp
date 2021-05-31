<%@ include file="common/header.jspf"%>


<article>

	<div class="container">
		<h1 class="article-heading text-center m-4">Medicine Stock</h1>
		<table class="table table-striped table-bordered bg-light rounded border-dark">
				<thead class="thead-dark">
				<tr class="text-center bg-secondary text-white" style="font-size: 1.3em;">
					
					<th style="vertical-align: middle;">Id</th>
					<th style="vertical-align: middle;">Name</th>
					<th style="vertical-align: middle;">Chemical Composition</th>
					<th style="vertical-align: middle;">Target Ailment</th>
					<th style="vertical-align: middle;">Godown Name</th>
					<th style="width: 7em;vertical-align: middle;">Date Of Expiry</th>
					<th style="vertical-align: middle;"> Stock</th>
				</tr>
			</thead>
			<c:forEach items="${medicineStockList}" var="medicineStock">
				<tr>
					<td>${medicineStock.medicineId}</td>
					<td>${medicineStock.medicineName}</td>
					<td>${medicineStock.chemicalComposition}</td>
					<td>${medicineStock.targetAilment}</td>
					<td>${medicineStock.godownName}</td>
					<td>${medicineStock.dateOfExpiry}</td>
					<td class="text-center">${medicineStock.numberOfTabletsInStock}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</article>


<%@ include file="common/footer.jspf"%>