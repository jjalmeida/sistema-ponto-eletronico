package br.com.ponto.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import br.com.ponto.controller.MarcaPontoControl;
import br.com.ponto.dao.MarcaPontoDao;
import br.com.ponto.entity.Funcionario;
import br.com.ponto.entity.MarcaPonto;
import br.com.ponto.login.UsuarioLogadoBean;

@ManagedBean
@SessionScoped
public class PontoBean {

	private MarcaPontoDao dao = new MarcaPontoDao();

	private MarcaPonto ponto;
	
	@Inject
	private UsuarioLogadoBean funcionario;

	private Date dataInicio;
	private Date dataFim;
	private List<MarcaPonto> listaPontoFuncionario;
	private List<MarcaPonto> listaPonto;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<MarcaPonto> getListaPontoFuncionario() {
		return listaPontoFuncionario;
	}

	/*
	 * public Funcionario getFuncionario() { return funcionario; }
	 */
	public MarcaPonto getPonto() {
		return ponto;
	}

	public void setPonto(MarcaPonto ponto) {
		this.ponto = ponto;
	}

	// Validar
	public List<MarcaPonto> getListaPonto(Funcionario funcionario) {
		listaPonto = new MarcaPontoDao().getPontoCorrente(funcionario);
		return listaPonto;
	}

	// Validar
	public void marcarPonto(Funcionario funcionario) {
		if (funcionario != null) {
			new MarcaPontoControl().marcarPonto(funcionario);
			listaPonto = dao.getPontoCorrente(funcionario);

			Date data = Calendar.getInstance().getTime();
			SimpleDateFormat format = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm:ss");
			System.out.println("Marca ponto: " + funcionario.getNome() + " "
					+ format.format(data));
		}
	}

	// Validar
	public void pontoDiarioFuncionario() {
		this.listaPontoFuncionario = new MarcaPontoDao()
				.getPontoInvervaloPorUsuario(dataInicio, dataFim, funcionario.getUsuario());
	}
	
	public void menssagem(){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"AVISO","Marcado ponto com sucesso!!!");
		RequestContext.getCurrentInstance().showMessageInDialog(msg);
	}

}
