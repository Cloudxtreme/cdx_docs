class Cms6060nController < ApplicationController

	def index
    lbound = 3000001
    hbound = 0

    (3000001..5000000).each do |i|
#    (1..1230).each do |i|
      hbound = i
      if i % 100000 == 0
        puts "#{lbound} #{hbound}"
				write2file(Cms6060n.CDx_new(lbound,hbound), "output_#{lbound}_#{hbound}.txt")
        lbound = i+1
      end
    end
		write2file(Cms6060n.CDx_new(lbound,hbound), "output_#{lbound}_#{hbound}.txt")
	end

	def write2file(records, filename)
        fd = File.open(filename, 'w')
        records.each do |record|
							if record.Healthcare_Provider_Taxonomy_Code_15 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_15
							elsif record.Healthcare_Provider_Taxonomy_Code_14 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_14
							elsif record.Healthcare_Provider_Taxonomy_Code_13 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_13
							elsif record.Healthcare_Provider_Taxonomy_Code_12 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_12
							elsif record.Healthcare_Provider_Taxonomy_Code_11 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_11
							elsif record.Healthcare_Provider_Taxonomy_Code_10 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_10
							elsif record.Healthcare_Provider_Taxonomy_Code_9 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_9
							elsif record.Healthcare_Provider_Taxonomy_Code_8 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_8
							elsif record.Healthcare_Provider_Taxonomy_Code_7 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_7
							elsif record.Healthcare_Provider_Taxonomy_Code_6 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_6
							elsif record.Healthcare_Provider_Taxonomy_Code_5 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_5
							elsif record.Healthcare_Provider_Taxonomy_Code_4 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_4
							elsif record.Healthcare_Provider_Taxonomy_Code_3 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_3
							elsif record.Healthcare_Provider_Taxonomy_Code_2 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_2
							elsif record.Healthcare_Provider_Taxonomy_Code_1 != ''
								tcode = record.Healthcare_Provider_Taxonomy_Code_1
							end


							if record.Healthcare_Provider_Taxonomy_Group_15 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_15
							elsif record.Healthcare_Provider_Taxonomy_Group_14 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_14
							elsif record.Healthcare_Provider_Taxonomy_Group_13 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_13
							elsif record.Healthcare_Provider_Taxonomy_Group_12 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_12
							elsif record.Healthcare_Provider_Taxonomy_Group_11 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_11
							elsif record.Healthcare_Provider_Taxonomy_Group_10 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_10
							elsif record.Healthcare_Provider_Taxonomy_Group_9 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_9
							elsif record.Healthcare_Provider_Taxonomy_Group_8 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_8
							elsif record.Healthcare_Provider_Taxonomy_Group_7 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_7
							elsif record.Healthcare_Provider_Taxonomy_Group_6 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_6
							elsif record.Healthcare_Provider_Taxonomy_Group_5 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_5
							elsif record.Healthcare_Provider_Taxonomy_Group_4 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_4
							elsif record.Healthcare_Provider_Taxonomy_Group_3 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_3
							elsif record.Healthcare_Provider_Taxonomy_Group_2 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_2
							elsif record.Healthcare_Provider_Taxonomy_Group_1 != ''
								tgroup = record.Healthcare_Provider_Taxonomy_Group_1
							end

							fd.puts "#{record.NPI},#{tcode},#{tgroup},#{record.Entity_Type_Code},#{record.Replacement_NPI},#{record.Employer_Identification_Number_EIN},#{record.Provider_Organization_Name_Legal_Business_Name},#{record.Provider_Last_Name_Legal_Name},#{record.Provider_First_Name},#{record.Provider_Middle_Name},#{record.Provider_Name_Prefix_Text},#{record.Provider_Name_Suffix_Text},#{record.Provider_Credential_Text},#{record.Provider_Other_Organization_Name},#{record.Provider_Other_Organization_Name_Type_Code},#{record.Provider_First_Line_Business_Mailing_Address},#{record.Provider_Second_Line_Business_Mailing_Address},#{record.Provider_First_Line_Business_Practice_Location_Address},#{record.Provider_Second_Line_Business_Practice_Location_Address},#{record.Provider_Business_Practice_Location_Address_City_Name},#{record.Provider_Business_Practice_Location_Address_State_Name},#{record.Provider_Business_Practice_Location_Address_Postal_Code},#{record.Provider_Business_Practice_Location_Address_Country_outside_US},#{record.Provider_Business_Practice_Location_Address_Telephone_Number},#{record.Provider_Business_Practice_Location_Address_Fax_Number},#{record.Provider_Enumeration_Date},#{record.Last_Update_Date},#{record.NPI_Deactivation_Reason_Code},#{record.NPI_Deactivation_Date},#{record.NPI_Reactivation_Date},#{record.Provider_Gender_Code},#{record.Authorized_Official_Last_Name},#{record.Authorized_Official_First_Name},#{record.Authorized_Official_Middle_Name},#{record.Authorized_Official_Title_or_Position},#{record.Authorized_Official_Telephone_Number},#{record.Is_Sole_Proprietor},#{record.Is_Organization_Subpart},#{record.Parent_Organization_LBN},#{record.Parent_Organization_TIN},#{record.Authorized_Official_Name_Prefix_Text},#{record.Authorized_Official_Name_Suffix_Text},#{record.Authorized_Official_Credential_Text}"

        end

			fd.close
	end

end
