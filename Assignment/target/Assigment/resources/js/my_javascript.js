function Pager(tableName, itemsPerPage) {
    this.tableName = tableName;
    this.itemsPerPage = itemsPerPage;
    this.currentPage = 1;
    this.pages = 0;
    this.inited = false;
   
    this.showRecords = function(from, to) {      
        var rows = document.getElementById(tableName).rows;
        // i starts from 1 to skip table header row
        for (var i = 1; i < rows.length; i++) {
            if (i < from || i > to)
                rows[i].style.display = 'none';
            else
                rows[i].style.display = '';
        }
    }
   
    this.showPage = function(pageNumber) {
          if (! this.inited) {
                   alert("not inited");
                   return;
          }
 
        var oldPageAnchor = document.getElementById('pg'+this.currentPage);
        oldPageAnchor.className = 'pg-normal';
       
        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg'+this.currentPage);
        newPageAnchor.className = 'pg-selected';
       
        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
    }  
   
    this.prev = function() {
        if (this.currentPage > 1)
            this.showPage(this.currentPage - 1);
    }
   
    this.next = function() {
        if (this.currentPage < this.pages) {
            this.showPage(this.currentPage + 1);
        }
    }                      
   
    this.init = function() {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1);
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
    }
 
    this.showPageNav = function(pagerName, positionId) {
          if (! this.inited) {
                   alert("not inited");
                   return;
          }
          var element = document.getElementById(positionId);
         
          var pagerHtml = '<td><button onclick="' + pagerName + '.prev();" class="pg-normal"> &lt; </button></td>';
        for (var page = 1; page <= this.pages; page++)
            pagerHtml += '<td><button id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</button></td>';
        pagerHtml += '<td><button onclick="'+pagerName+'.next();" class="pg-normal"> &gt;</button></td>';          
       
        element.innerHTML = pagerHtml;
    }
}
        var num = 1;
        var id=1;
        
        // function reset() {
        //     document.getElementById("textbox0").value="";
        // }
        function addRow() {
            var table = document.getElementById("myTable");
            var row = table.insertRow(num);
            var cell1 = row.insertCell(0);
            cell1.innerHTML = '<input type="text" id="'+ id +'" value="'+id+'" readonly="true">';
            cell1= row.insertCell(1);
            cell1.innerHTML = '<input type="button" value="Browser" onclick="HandleBrowseClick('+id+')"> <input type="file" id="browse '+id+'" style="display: none" onChange="Handlechange('+id+')">';
            cell1 = row.insertCell(2);
            cell1.innerHTML = '<a value="Delete" onclick="deleteRow(this)" href="#">Remove..</a>';
            num+=1;id+=1;
        }

        function deleteRow() {
            document.getElementById("myTable").deleteRow(0);
        }
        }
        function HandleBrowseClick(id)
        {
            var fileinput = document.getElementById("browse"+id).click();
            
        }
        function Handlechange(id)
        {
            var x=a.parentNode.parentNode.rowIndex;
            var fileinput = document.getElementById("browse"+id);
            var textinput = document.getElementById(id);
            textinput.value = fileinput.value;
        }
        
        }
        function importfile(){

        }