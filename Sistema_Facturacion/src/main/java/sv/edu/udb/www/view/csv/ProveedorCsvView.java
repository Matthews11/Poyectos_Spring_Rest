package sv.edu.udb.www.view.csv;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import sv.edu.udb.www.models.entity.Proveedor;

@Component("proveedor/listar.csv")
public class ProveedorCsvView  extends AbstractView {

	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment; filename=\"proveedores.csv\"");
		response.setContentType(getContentType());
		
		
		Page<Proveedor> proveedores = (Page<Proveedor>) model.get("proveedores");
		
		ICsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(),  CsvPreference.STANDARD_PREFERENCE);
		
		String[] header = {"id", "proveedor", "repartidor", "telefono", "direccion" , "email"};
		beanWriter.writeHeader(header);
		
		for(Proveedor proveedor: proveedores) {
			beanWriter.write(proveedor, header);
		}
		beanWriter.close();
	}

	public ProveedorCsvView() {
		setContentType("text/csv");
	}
		@Override
		protected boolean generatesDownloadContent() {
			// TODO Auto-generated method stub
			return true ;
		}
}
