package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Run {

	public static void main(String[] args) throws IOException {
		
		Gson gson = new Gson();
		
		Object obj;
		try {
		    JsonParser parser = new JsonParser();
		    obj = parser.parse(new FileReader("data.json"));
		    JsonObject jsonObject = (JsonObject) obj;
		
		    Dados dados = gson.fromJson(jsonObject, Dados.class);
		    
		    FileWriter arq = new FileWriter("saida.json");
		    PrintWriter gravarArq = new PrintWriter(arq);

		    gravarArq.println("[");
		    
		    
		    for (int i=0; i<=8759; i++) {
		    	String ano = "2004";
		    	
		    	String concatenarData = dados.getDados().get(i).getDataHora().replace("/", "-");
		    	String[] split = concatenarData.split(" ");
		    	
		    	String concatenarHora = split[2];
		    	String[] hora = concatenarHora.split(":");
		    	
		    	int horaDia = Integer.parseInt(hora[0]) - 1;
		    	float eletricidadeInstalacao = dados.getDados().get(i).getEletricidadeInstalacao();
		    	float ventiladores = dados.getDados().get(i).getVentiladores();
		    	float refrigeracaoEletrico = dados.getDados().get(i).getRefrigeracaoEletrico();
    			float aquecimentoEletrico = dados.getDados().get(i).getAquecimentoEletrico();
    			float iluminacaoInterior = dados.getDados().get(i).getIluminacaoInterior();
    			float iluminacaoEquipamento = dados.getDados().get(i).getIluminacaoEquipamento();
    			float gasInstalacao = dados.getDados().get(i).getGasInstalacao();
    			float gasAquecimento = dados.getDados().get(i).getGasAquecimento();
    			float iluminacaoEquipamentoGas = dados.getDados().get(i).getIluminacaoEquipamentoGas();
    			float aquecedorAgua = dados.getDados().get(i).getAquecedorAgua();
		    	
		    	ano = ano + "-" + split[0] + split[1];
		    	
		    	gravarArq.println("[\""+
				    				ano +"\"," + horaDia + ","
				    				+ "["  
				    				+eletricidadeInstalacao +"," 
				    				+ventiladores +","
				    				+refrigeracaoEletrico +","
				    				+aquecimentoEletrico +","
				    				+iluminacaoInterior +","
				    				+iluminacaoEquipamento +","
				    				+gasInstalacao +","
				    				+gasAquecimento +","
				    				+iluminacaoEquipamentoGas +","
				    				+aquecedorAgua +""
				    				+"]" 
					    		  +"],");
		    	ano = "";
		     }
		    
		    gravarArq.println("]");
		    
		    arq.close();
		    
		    System.out.println("Fim");
		
		} catch (JsonIOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (JsonSyntaxException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (FileNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}

	}

}
