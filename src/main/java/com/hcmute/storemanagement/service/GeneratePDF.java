package com.hcmute.storemanagement.service;

import com.hcmute.storemanagement.DAO.StaffDao.AdminChiTietDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IAdminChiTietDonHang;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.IStaffKhachHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffDonHangDao;
import com.hcmute.storemanagement.DAO.StaffDao.StaffKhachHangDao;
import com.hcmute.storemanagement.models.ChiTietDonHang;
import com.hcmute.storemanagement.models.ChiTietDonNhapHang;
import com.hcmute.storemanagement.models.DonHang;
import com.hcmute.storemanagement.models.DonNhapHang;
import com.hcmute.storemanagement.models.KhachHang;
import com.hcmute.storemanagement.models.NhaCungCap;
import com.hcmute.storemanagement.models.NhanVien;
import com.hcmute.storemanagement.models.SanPham;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.util.ArrayList;

public class GeneratePDF {

    public void generateGDN(String billId) {
        IStaffKhachHangDao khachHangDao = new StaffKhachHangDao();
        IStaffNhanVienService nvService = new StaffNhanVienService();
        IAdminChiTietDonHang chitietDAO = new AdminChiTietDonHangDao();
        IStaffDonHangDao donhangDAO = new StaffDonHangDao();
        DonHang bill = donhangDAO.findBillById(billId);
        System.out.println("KH: " + bill.getMaKhachHang());
        KhachHang cus = khachHangDao.getKhachHangByID(bill.getMaKhachHang());
        NhanVien staff = nvService.getStaffById(bill.getMaNhanVien());
        List<ChiTietDonHang> listChiTiet = chitietDAO.getChiTietDonHangById(bill.getMaDonHang());
        IStaffSanPhamService spService = new StaffSanPhamService();
        List<SanPham> listSanPham = new ArrayList<SanPham>();
        for (ChiTietDonHang chitiet : listChiTiet) {
            SanPham sp = spService.getSanPhamById(chitiet.getMaSanPham());
            listSanPham.add(sp);
        }
        String FILE_NAME = "Bill-" + billId + ".pdf";

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
            document.open();

            Font titleFont = new Font(FontFamily.HELVETICA, 18, Font.BOLD);
            Font contentFont = new Font(FontFamily.HELVETICA, 12, Font.NORMAL);
            Font headerFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
            // Title
            Paragraph title = new Paragraph("Invoice", titleFont);
            Paragraph BillId = new Paragraph("Invoice No. " + bill.getMaDonHang(), contentFont);
            BillId.setAlignment(Element.ALIGN_RIGHT);
            Paragraph createAt = new Paragraph("Invoice Date: " + bill.getNgayDatHang(), contentFont);
            createAt.setAlignment(Element.ALIGN_RIGHT);
            document.add(title);
            document.add(BillId);
            document.add(createAt);
            // Line separator
            LineSeparator line = new LineSeparator();
            document.add(new Paragraph(" "));
            document.add(line);
            document.add(new Paragraph(" "));

            PdfPTable info = new PdfPTable(2); // 2 columns for customer and staff info
            info.setWidthPercentage(100);
            PdfPCell cusId;
            PdfPCell cusName;
            PdfPCell staffId;
            PdfPCell staffName;
            // Customer Info
            staffId = new PdfPCell(new Phrase("Staff ID: " + staff.getMaNhanVien())); // Applying bold font to the header cell
            staffName = new PdfPCell(new Phrase("Staff Name: " + staff.getTenNhanVien())); // Applying bold font to the header cell

            staffId.setBorder(0);
            staffName.setBorder(0);
            if (cus != null) {
                cusId = new PdfPCell(new Phrase("Customer ID: " + cus.getMaKhachHang())); // Applying bold font to the header cell
                cusName = new PdfPCell(new Phrase("Customer Name: " + cus.getTenKhachHang()));
                cusId.setBorder(0);
                cusName.setBorder(0);
                info.addCell(cusId);
                info.addCell(staffId);
                info.addCell(cusName);
                info.addCell(staffName);
            } else {
                info.addCell(staffId);
                info.addCell(staffName);
            }
            document.add(info);
            // Content
            // Content
            PdfPTable table = new PdfPTable(4); // 4 columns
            table.setWidthPercentage(100);

            PdfPCell headerCell1 = new PdfPCell(new Phrase("Product ID", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell2 = new PdfPCell(new Phrase("Product Name", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell3 = new PdfPCell(new Phrase("Quantity", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell4 = new PdfPCell(new Phrase("Price", headerFont)); // Applying bold font to the header cell

            headerCell1.setPadding(5);
            headerCell2.setPadding(5);
            headerCell3.setPadding(5);
            headerCell4.setPadding(5);

            table.addCell(headerCell1);
            table.addCell(headerCell2);
            table.addCell(headerCell3);
            table.addCell(headerCell4);
            for (int i = 0; i < listChiTiet.size(); i++) {
                table.addCell(listChiTiet.get(i).getMaSanPham());
                table.addCell(listSanPham.get(i).getTenSanPham());
                table.addCell(String.valueOf(listChiTiet.get(i).getSoLuong()));
                table.addCell(String.valueOf(listSanPham.get(i).getGia()));
            }
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            Paragraph productTitle = new Paragraph("Products", titleFont);
            document.add(productTitle);
            document.add(new Paragraph(" "));
            document.add(table);

            document.add(new Paragraph(" "));
            document.add(line);
            document.add(new Paragraph(" "));

            int tempCost = 0;
            for (int i = 0; i < listChiTiet.size(); i++) {
                tempCost += listSanPham.get(i).getGia() * listChiTiet.get(i).getSoLuong();
            }
            Paragraph tmpCost = new Paragraph("Temporary Cost:   " + String.valueOf(tempCost), contentFont);
            tmpCost.setAlignment(Element.ALIGN_RIGHT);
            document.add(tmpCost);

            int discount = 100 - (int) Math.round((double) bill.getTongGiaTri() / tempCost * 100);
            Paragraph discountText = new Paragraph("Discount:   " + discount + "%", contentFont);
            discountText.setAlignment(Element.ALIGN_RIGHT);
            document.add(discountText);

            Paragraph total = new Paragraph("Total Cost:   " + bill.getTongGiaTri(), contentFont);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();
            System.out.println("Invoice successfully generated and saved as " + FILE_NAME);

        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void generateGRN(String billId) {
        IAdminNhaCungCapService nccDAO = new AdminNhaCungCapService();

        IAdminChiTietDonNhapHangService chitietDAO = new AdminChiTietDonNhapHangService();
        IAdminDonNhapHangService donhangDAO = new AdminDonNhapHangService();
        DonNhapHang bill = donhangDAO.getById(billId);
        NhaCungCap ncc = nccDAO.getById(bill.getMaNhaCungCap());
        List<ChiTietDonNhapHang> listChiTiet = chitietDAO.getGRNDetailgByGRNId(bill.getMaDonNhapHang());
        IStaffSanPhamService spService = new StaffSanPhamService();
        List<SanPham> listSanPham = new ArrayList<SanPham>();
        for (ChiTietDonNhapHang chitiet : listChiTiet) {
            SanPham sp = spService.getSanPhamById(chitiet.getMaSanPham());
            listSanPham.add(sp);
        }
        String FILE_NAME = "GRN_Bill-" + billId + ".pdf";

        try {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));
            document.open();

            Font titleFont = new Font(FontFamily.HELVETICA, 18, Font.BOLD);
            Font contentFont = new Font(FontFamily.HELVETICA, 12, Font.NORMAL);
            Font headerFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
            // Title
            Paragraph title = new Paragraph("Invoice", titleFont);
            Paragraph BillId = new Paragraph("Invoice No. " + bill.getMaDonNhapHang(), contentFont);
            BillId.setAlignment(Element.ALIGN_RIGHT);
            Paragraph createAt = new Paragraph("Invoice Date: " + bill.getNgayNhapHang(), contentFont);
            createAt.setAlignment(Element.ALIGN_RIGHT);
            document.add(title);
            document.add(BillId);
            document.add(createAt);
            // Line separator
            LineSeparator line = new LineSeparator();
            document.add(new Paragraph(" "));
            document.add(line);
            document.add(new Paragraph(" "));

            Paragraph nccId = new Paragraph("Supplier ID: " + bill.getMaNhaCungCap(), contentFont);
            Paragraph nccName = new Paragraph("Name: " + ncc.getTenNhaCungCap(), contentFont);
            Paragraph address = new Paragraph("Address: " + ncc.getDiaChi(), contentFont);
            Paragraph phone = new Paragraph("Phone Number:  " + ncc.getSoDienThoai(), contentFont);
            document.add(nccId);
            document.add(nccName);
            document.add(address);
            document.add(phone);

            // Content
            // Content
            PdfPTable table = new PdfPTable(4); // 4 columns
            table.setWidthPercentage(100);

            PdfPCell headerCell1 = new PdfPCell(new Phrase("Product ID", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell2 = new PdfPCell(new Phrase("Product Name", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell3 = new PdfPCell(new Phrase("Quantity", headerFont)); // Applying bold font to the header cell
            PdfPCell headerCell4 = new PdfPCell(new Phrase("Price", headerFont)); // Applying bold font to the header cell

            headerCell1.setPadding(5);
            headerCell2.setPadding(5);
            headerCell3.setPadding(5);
            headerCell4.setPadding(5);

            table.addCell(headerCell1);
            table.addCell(headerCell2);
            table.addCell(headerCell3);
            table.addCell(headerCell4);
            for (int i = 0; i < listChiTiet.size(); i++) {
                table.addCell(listChiTiet.get(i).getMaSanPham());
                table.addCell(listSanPham.get(i).getTenSanPham());
                table.addCell(String.valueOf(listChiTiet.get(i).getSoLuong()));
                table.addCell(String.valueOf(listSanPham.get(i).getGia()));
            }
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            Paragraph productTitle = new Paragraph("Products", titleFont);
            document.add(productTitle);
            document.add(new Paragraph(" "));
            document.add(table);

            document.add(new Paragraph(" "));
            document.add(line);
            document.add(new Paragraph(" "));

            int tempCost = 0;
            for (int i = 0; i < listChiTiet.size(); i++) {
                tempCost += listSanPham.get(i).getGia() * listChiTiet.get(i).getSoLuong();
            }
            Paragraph tmpCost = new Paragraph("Total Cost:   " + String.valueOf(tempCost), contentFont);
            tmpCost.setAlignment(Element.ALIGN_RIGHT);
            document.add(tmpCost);

            document.close();
            System.out.println("Invoice successfully generated and saved as " + FILE_NAME);

        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        GeneratePDF gen = new GeneratePDF();

        gen.generateGDN("DH018");

    }
}
