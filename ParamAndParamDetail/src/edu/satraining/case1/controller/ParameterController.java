package edu.satraining.case1.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.satraining.model.Parameter;
import edu.satraining.model.ParameterDetail;
import edu.satraining.service.ParameterService;
import edu.satraining.service.ParameterServiceImpl;
import edu.satraining.utility.ServiceException;

public class ParameterController
	{
		private static final Logger Logger = LogManager.getLogger(ParameterController.class);
		private Scanner scanner;
		private String selectedMenu;
		private ParameterService parameterService;
		SimpleDateFormat sdf;

		public ParameterController()
		{
			scanner = new Scanner(System.in);
			parameterService = new ParameterServiceImpl();
			sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		}
	
/**
*
*/
		private void showMenu()
	{
		System.out.printf("%nAplikasi mengelola data Parameter%n%n");
		System.out.printf("Menu Aplikasi%n");
		System.out.printf("=======================================%n");
		System.out.printf("[S] Tampilkan Parameter%n");
		System.out.printf("[A] Tambah Parameter%n");
		System.out.printf("[E] Ubah Parameter%n");
		System.out.printf("[D] Hapus Parameter%n");
		System.out.printf("[X] Keluar");
    }
/**
*
*/
	private void readSelectedMenu()
	{
		String inputData;
		while (true)
		{
		System.out.printf("Pilih Menu [S / A / E / D / X]: ");
		inputData = scanner.nextLine();
		if (inputData.equalsIgnoreCase("S") || inputData.equalsIgnoreCase("A") || inputData.equalsIgnoreCase("E") ||
				inputData.equalsIgnoreCase("D") || inputData.equalsIgnoreCase("X"))
		{
		selectedMenu = inputData.toUpperCase();
		break;
     	}
        System.out.printf("Menu yang di pilih salah........%n");
	 	}
	}

/**
*
*/
		public void mainFunction()
		{
			Boolean finish = false;
			while (!finish)
			{
				showMenu();
				readSelectedMenu();
				switch (selectedMenu)
				{
				case "X" :
				finish = true;
				break;
				case "S" :
				searchFunction();
				break;
				case "A" :
				addFunction();
				break;
				case "E" :
				editFunction();
				break;
				case "D" :
				deleteFunction();
				break;
			}

		/*	if (selectedMeny.equalsIgnoreCase(“x”))
			{
			finish = true
			}
			else if (selectedMenu.equalsIgnoreCase(“S”))
			{
			searchFunction();
			}
			else if (selectedMenu.equalsIgnoreCase(“A”)
			{
			addFunction();
			}
			Else if (selectedMenu.equalsIgnoreCase (“E”))
			{
			editfunction();
			}
			else if (selected menu.equalsIgnoreCase(“D”))
			{
			 deleteFunction();
			}
			}
		*/
			}
				System.out.printf("%nTerima kasih, anda sudah keluar dari aplikasi%n");
			}
				private void searchFunction()
			{
			List<Parameter> parameters = null;
			try
			{
					parameters = parameterService.searchParameter();
				}
					catch(ServiceException e)
				{
					e.printStackTrace();
				}
					System.out.printf("%nTampilkan Parameter%n%n");
					System.out.printf("%-20s %-20s %-20s %-16s %-20s%n”, “kode Parameter”, “Nama Parameter”, “Deskripsi”, “Dibuat oleh”, “Dibuat Tanggal”, “Diubah oleh");
					System.out.printf ("============================================================================================%n");
					if (parameters.size() == 0)
				{
					System.out.printf("Tidak ada data %n");
				}
					else
				{
					for (Parameter parameter : parameters)
					{
						System.out.printf ("%-20s %-20s %-20s %-16s %-20s%n",
						parameter.getParamCode(),
						parameter.getParamName(),
						parameter.getDescription(),
						parameter.getCreatedBy(),
						parameter.getCreatedBy(),
						parameter.getCreatedTime() == null ? "" : sdf.format(parameter.getCreatedTime()),
						parameter.getUpdatedBy(),
						parameter.getUpdatedTime() == null ? "" : sdf.format(parameter.getUpdatedTime()));
					}
			}
				System.out.printf("=====================================================================================================%n");
				System.out.printf("%nTekan Enter Untuk Menampilkan menu%n");
				scanner.nextLine();
			}
/**
*
*/
	private String readParamCode()
	{
		String inputData = null;
		String title = "Kode Parameter";
		while (true)
			{
				System.out.printf("%16s : ", title);
				inputData = scanner.nextLine();
				if (inputData.trim().length() !=0)
					{
						break;
					}
					System.out.printf("%s harus diisi…%n", title);
			}
			return inputData;
	}

/**
*
*/
	private String readParamName()
	{
		String inputData = null;
		String title = "Nama Parameter";
		while (true)
			{
				System.out.printf("%16s : ", title);
				inputData = scanner.nextLine();
				if (inputData.trim().length() !=0)
				{
					break;
				}
				System.out.printf("%s harus diisi…%n", title);
			}
			return inputData;
	}
/**
*
*/
	private String readDescription()
	{
		String inputData = null;
		String title = "Deskripsi";

		while (true)
			{
				System.out.printf("%16s : ", title);
				inputData = scanner.nextLine();
				if (inputData.trim().length() !=0)
				{
					break;
				}
				System.out.printf("%s harus diisi......%n", title);
			}
		return inputData;
	}
/**
*
*/
	private String readDetailCode()
	{
		String inputData = null;
		String title = "Kode Detail";
		while (true)
			{
				System.out.printf("%16s : ", title);
				inputData = scanner.nextLine();
				if (inputData.trim().length() !=0)
				{
					break;
				}
				System.out.printf("%s harus diisi......%n", title);
			}
		return inputData;
	}
/**
*
*/
	private String readDetailName()
	{
		String inputData = null;
		String title = "Nama Detail";
		while (true)
		{
			System.out.printf("%16s : ", title);
			inputData = scanner.nextLine();
			if (inputData.trim().length() !=0)
			{
				break;
			}
			System.out.printf("%s harus diisi…%n", title);
		}
	return inputData;
	}
/**
*
*/
	private String readDetailValue()
	{
		String inputData = null;
		String title = "Nilai";
		while (true)
		{
			System.out.printf("%16s : ", title);
			inputData = scanner.nextLine();
			if (inputData.trim().length() !=0)
			{	
				break;
			}
			System.out.printf("%s harus diisi…%n", title);
		}
		return inputData;
	}


	private String readConfirmation()
	{
		String inputData;
		while (true)
		{
			System.out.printf("[Y] Ya [N] Tidak : ");
			inputData = scanner.nextLine();
		if (inputData.equalsIgnoreCase("Y") || inputData.equalsIgnoreCase("N"))
		{		
		return inputData.toUpperCase();
		}
		System.out.printf("Menu yang dipilih salah…%n");
	}
}

/**
*
*/
	private void addFunction()
	{
		Parameter parameter = new Parameter();
		String confirmation = null;

		addFunctionReadHeader(parameter);
		addFunctionReadDetail(parameter);
		confirmation = addFunctionConfirmation(parameter);

		if (confirmation.equalsIgnoreCase("Y"))
		{
			Date currentDate = new java.util.Date(System.currentTimeMillis());
			/* add value for createdBy and createdTime */
			parameter.setCreatedBy("Admin");
			parameter.setCreatedTime(currentDate);

		for (ParameterDetail paramDetail : parameter.getDetails())
		{
			paramDetail.setCreatedBy("Admin");
			paramDetail.setCreatedTime(currentDate);
		}	
		
		try
		{
			parameterService.addParameter(parameter);
			System.out.printf("%nParameter baru berhasil ditambahkan…%n");
		}
		catch (ServiceException e)
		{
			System.out.printf("%nParameter baru gagal ditambahkan…%n");
			Logger.error("Parameter baru gagal ditambahkan…%n");
			Logger.error(e.getCause().fillInStackTrace());
		}
	}
		System.out.printf("%nTekan Enter untuk kembali ke menu%n");
		scanner.nextLine();
}
/**
*
*/
	private void addFunctionReadHeader(Parameter parameter)
	{
		System.out.printf("%nTambah Parameter%n");
		System.out.printf("==============%n");
		System.out.printf("Parameter%n");
	/* read data parameter from keyboard */
	parameter.setParamCode(readParamCode());
	parameter.setParamName(readParamName());
	parameter.setDescription(readDescription());
	}


	private void addFunctionReadDetail(Parameter parameter)
	{
	ParameterDetail parameterDetail = null;
	String detailCode = null;
	int counter = 1;

	/* read data Parameter Detail from keyboard */
	System.out.printf("%nDetail%n");
	System.out.printf("Isi Kode Detail dengan * untuk selesaikan%n");
	while (true)
	{
		System.out.printf("%Parameter Detail ke-%d%n", counter);
		detailCode = readDetailCode();
		if (detailCode.equals("*"))
		{
			break;
		}
		parameterDetail = new ParameterDetail();
		parameterDetail.setDetailCode(detailCode);
		parameterDetail.setDetailName(readDetailName());
		parameterDetail.setDetailValue(readDetailValue());
		
		parameter.addDetails(parameterDetail);
		counter++;
	}
}


	private String addFunctionConfirmation(Parameter parameter)
	{
	/* confirmation to save data */
	System.out.printf("%n%nData yang sudah di isi%n%n");
	System.out.printf("%16s  :  %s%n", "Kode Parameter", parameter.getParamCode());
	System.out.printf("%16s  :  %s%n", "Nama Parameter", parameter.getParamName());
	System.out.printf("%16s  :  %s%n%n", "Deskripsi", parameter.getDescription());

	System.out.printf("%-20s %-20s %-20s%n", "Kode Detail", "Nama Detail", "Nilai");
	System.out.printf("-------------------------------------------------------------%n");
	if (parameter.getDetails().size() == 0)
	{
		System.out.printf("Tidak ada data Parameter Detail%n");
	}
	else
	{
	for (ParameterDetail paramDetail : parameter.getDetails())
		{
			System.out.printf("%-20s %-20s %-20s%n", paramDetail.getDetailCode(), paramDetail.getDetailName(), paramDetail.getDetailValue());
		}
	}
	System.out.printf("--------------------------------------------------------------%n");

	System.out.printf("%nAnda yakin menyimpan data ini?%n");
	return readConfirmation();
}


 
	private void editFunction ()
	{
		String paramCode = null;
		Parameter parameterCurrent = null,
				  parameterNew = null;
		List<ParameterDetail> detailsCurrent = null,
							  detailsNew = new ArrayList<ParameterDetail>();
		System.out.printf("%nUbah Parameter%n");
		System.out.printf("----------------%n");

		paramCode = readParamCode();

		try
		{
			Parameter parameter = new Parameter(paramCode);
			parameterCurrent = parameterService.findById(paramCode);
			detailsCurrent = parameterService.getChild(parameter);
			parameterCurrent.setDetails(detailsCurrent);
		}	
		catch (ServiceException e)
		{
			//:TODO
		}

		/* clone parameter and parameter detail list */
		parameterNew  = (Parameter)parameterCurrent.clone();
		// parameterNew = parameterCurrent;

		// detailsNew = detailsCurrent;
		for (ParameterDetail parameterDetail : detailsCurrent)
		{
			detailsNew.add((ParameterDetail)parameterDetail.clone());
		}
		parameterNew.setDetails(detailsNew);

		System.out.printf("%nData Parameter Saat Ini%n");
		showParameter(parameterCurrent);

		boolean finish = false;
		String action = null;
		while (!finish)
		{
			System.out.printf("%n____________________________________________________________________________________%n");
			System.out.printf("%nPilih Aksi Yang Akan Dilakukan%n");
			action = readAction();
			if (action.equals("1"))
			{
				editFunctionUpdateHeader(parameterNew);
				System.out.printf("%nData Parameter Saat Ini%n");
				showParameter(parameterCurrent);
				System.out.printf("%nData Parameter Baru");
				showParameter(parameterNew);
			}
			else if (action.equals("2"))
			{
				editFunctionAddDetail(parameterNew);
				System.out.printf("%nData Parameter Saat Ini%n");
				showParameter(parameterCurrent);
				System.out.printf("%nData Parameter Baru");
				showParameter(parameterNew);
			}
			else if (action.equals("3"))
			{
				editFunctionEditDetail(parameterNew);
				System.out.printf("%nData Parameter Saat Ini%n");
				showParameter(parameterCurrent);
				System.out.printf("%nData Parameter Baru");
				showParameter(parameterNew);
			}
			else if (action.equals("4"))
			{
				editFunctionDeleteDetail(parameterNew);
				System.out.printf("%nData Parameter Saat Ini%n");
				showParameter(parameterCurrent);
				System.out.printf("%nData Parameter Baru");
				showParameter(parameterNew);
			}
			else if (action.equals("S"))
			{
				try
				{
					parameterService.updateParameter(parameterNew);
					System.out.printf("%nParameter %s berhasil diubah...%n", parameterCurrent.getParamCode());
				}
				catch (ServiceException e)
				{
					System.out.printf("%nParameter %s gagal diubah.....%n", parameterCurrent.getParamCode());
					Logger.error(String.format("%nParameter %s gagal diubah.....%n", parameterCurrent.getParamCode()));
					Logger.eror(e.getCause().fillInStackTrace());
				}
				finish = true;
			}
			else if (action.equals("C"))
			{
				finish = true;
			}
		}
	}

	private void showParameter(Parameter parameter)
	{
		/* Parameter data */
		System.out.printf("%16s : %s%sn", "Kode Parameter", parameter.getParamCode());
		System.out.printf("%16s : %s%sn", "Nama Parameter", parameter.getParamName());
		System.out.printf("%16s : %s%sn", "“Deskripsi”", parameter.getDescription());

		System.out.printf("%-20s %-20s %20s", "Kode Detail", "Nama Detail", "Nilai");
		System.out.printf("------------------------------------------------------------------------%n");
		if (parameter.getDetails().size() == 0)
		{
			System.out.printf("Tidak ada data Parameter Detail%n");
		}
		else
		{
			for (ParameterDetail paramDetail : parameter.getDetails())
			{
				System.out.printf("%-20s %-20s %-20s%n", paramDetail.getDetailCode(), paramDetail.getDetailName(), paramDetail.getDetailValue());
			}

		}
		System.out.printf("--------------------------------------------------------------------------------------------------------------%n");
	}


	private String readAction()
	{
		String action;

		while (true)
		{
			System.out.printf("%n[1] Ubah Parameter | [2] Tambah Detail | [3] Ubah Detail | [4] Hapus Detail | [S] Simpan | [C] Batal : ");
			action = scanner.nextLine();
			if (action.equals("1") || action.equals("2") || action.equals("3") || action.equals("4")
				|| action.equalsIgnoreCase("S") || action.equalsIgnoreCase("C"))
			{
				return action.toUpperCase();
			}
			System.out.printf("Menu yang dipilih salah…%n");
		}
	}


	private void editFunctionUpdateHeader(Parameter parameter)
	{
		System.out.printf("%nData Parameter Baru%n");
		System.out.printf("----------------------%n");

		/* read data Parameter from keyboard */
		parameter.setParamName(readParamName());
		parameter.setDescription(readDescription());

		System.out.printf("%nTekan Enter untuk kembali ke layar utama fungsi Ubah%n");
		scanner.nextLine();
	}


	private void editFunctionAddDetail(Parameter parameter)
	{
		ParameterDetail parameterDetail = null;

		/*read data Parameter Detail From Keyboard */
		System.out.printf("%nTambah Parameter Detail%n");
		parameterDetail = new ParameterDetail ();
		parameterDetail.setDetailCode(readDetailCode());
		parameterDetail.setDetailName(readDetailName());
		parameterDetail.setDetailValue(readDetailValue());
		parameter.addDetails(parameterDetail);

		System.out.printf("%nTekan Enter untuk kembali ke layar utama fungsi Ubah%n");
		scanner.nextLine();
	}


	private void editFunctionEditDetail(Parameter parameter)
	{
		ParameterDetail parameterDetail = null;
		String detailCode = null;

		/* read data Parameter Detail from Keyboard */
		System.out.printf("%nUbah Parameter Detail%n");
		detailCode = readDetailCode();
		parameterDetail = findDetail(detailCode, parameter);
		if (parameterDetail == null)
		{
			System.out.printf("%nParameter Detail with Detail Code: %s not found%n", detailCode);
		}
		else
		{
			System.out.printf("%nParameter Detail Saat Ini%n");
			System.out.printf("---------------------------%n");
			System.out.printf("%16s : %s%n", "Kode Detail", parameterDetail.getDetailCode());
			System.out.printf("%16s : %s%n", "Nama Detail", parameterDetail.getDetailName());
			System.out.printf("%16s : %s%n", "Nilai", parameterDetail.getDetailValue());

			System.out.printf("%nParameter Detail Terbaru%n");
			System.out.printf("-------------------------%n");
			parameterDetail.setDetailName(readDetailName());
			parameterDetail.setDetailValue(readDetailValue());
		}
		System.out.printf("%nTekan Enter untuk kembali ke layar utama fungsi Ubah%n");
		scanner.nextLine();
	}


	private ParameterDetail findDetail(String detailCode, Parameter parameter)
	{
		ParameterDetail result = null;

		for (ParameterDetail parameterDetail : parameter.getDetails())
		{
			if (parameterDetail.getDetailCode().equals(detailCode))
			{
				result = parameterDetail;
				break;
			}
		}
		return result;
	}


	private void editFunctionDeleteDetail(Parameter parameter)
	{
		ParameterDetail parameterDetail = null;
		String detailCode = null;

		/*read data parameter from keyboard*/
		System.out.printf("%nHapus Parameter Detail%n");
		detailCode = readDetailCode();
		parameterDetail = findDetail(detailCode, parameter);
		if (parameterDetail == null)
		{
			System.out.printf("%nParameter Detail with Detail Code: %s not found%n", detailCode);
		}
		parameter.removeDetails(parameterDetail);

		System.out.printf("%nTekan Enter untuk kembali ke layar utama fungsi Ubah%n");
		scanner.nextLine();
	}


	private void deleteFunction()
	{
		String paramCode = null;
		int result = 0;

		System.out.printf("%nHapus Buku%n");
		System.out.printf("===========%n");
		paramCode = readParamCode();

		try
		{
			result = parameterService.deleteParameter(new Parameter(paramCode));
		}
		catch(ServiceException e)
		{
			e.printStackTrace();
			System.out.printf("%nTerjadi kesalahan pada waktu akses database...%n");
			System.out.printf("%nTekan Enter untuk kembali ke menu...%n");
			Logger.error(e);
			scanner.nextLine();
			return;
		}

		if (result > 0)
		{
			System.out.printf("%nParameter dengan Kode %s berhasil dihapus...%n", paramCode);
		}
		else
		{
			System.out.printf("%nParameter dengan Kode %s tidak ditemukan...%n", paramCode);
		}
		System.out.printf("%nTekan Enter untuk kembali ke menu%n");
		scanner.nextLine();
	}
}	
