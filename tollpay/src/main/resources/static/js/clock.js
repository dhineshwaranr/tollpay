(function($){
 
  $.fn.clock = function(options) {
    
            var dataintera = new Date();
            var HH = dataintera.getHours();
            var MM = dataintera.getMinutes();
            var SS = dataintera.getSeconds(); 
            
            var defaults = {font_size:22 , color:'red'};
            var options = $.extend(defaults, options);
           
            return this.each(function() { 
          
           var str = '<span class="hh"></span>&nbsp;:&nbsp;<span class="mm"></span>&nbsp;:&nbsp;<span class="ss"></span>';
           $(this).html(str).css({'font-size': options.font_size+'px', 'color': options.color}); 
           
           if(SS<=9){
           $(' span.ss').html('0'+SS); 
           }
           else{
            $(' span.ss').html(SS);  
           };
           
           if(MM<=9){
            $(' span.mm').html('0'+MM);
            
           }else{
            $(' span.mm').html(MM);
            };
           
           if(HH<=9){
            $(' span.hh').html('0'+HH);
            
           }else{
            $(' span.hh').html(HH);
            };
            
           
           setInterval(function(){
           var dataintera = new Date();
           var HH = dataintera.getHours();
           var MM = dataintera.getMinutes();
           var SS = dataintera.getSeconds();
           
           if(SS<=9){$('span.ss').html('0'+SS);         
            } else{$('span.ss').html(SS);  
           };
           
          if(MM<=9){$('span.mm').html('0'+MM);
            }else{$('span.mm').html(MM);
            };
           
           if(HH<=9){$('span.hh').html('0'+HH);
            }else{$('span.hh').html(HH);
            };
           
           },1000);
           
      
               
    });   
         
           
         
 };  
})(jQuery);	
